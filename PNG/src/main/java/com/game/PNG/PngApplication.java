package com.game.PNG;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
@RestController
@EntityScan("com.game.PNG")
public class PngApplication {

	private static final Logger log = LoggerFactory.getLogger(PngApplication.class);
	private static final Game FGG = new Game(5);

	@Autowired //don't forget the setter
	private GameRepository gameRepository;

	@Autowired //don't forget the setter
	private AccountHolderRepository accountHolderRepository;

	public static void main(String[] args) {
		SpringApplication.run(PngApplication.class, args);
	}


	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		log.info("Accessed Hello");
		return String.format("Hello %s!", name);
	}

	@GetMapping("/token")
	public String getAccessToken(
			@RegisteredOAuth2AuthorizedClient("github") OAuth2AuthorizedClient authorizedClient,
			OAuth2AuthenticationToken authentication) {
		log.info("Accessed token");
		return "Access Token: " + authorizedClient.getAccessToken().getTokenValue();
	}

	//'create' a new five game resource
	//One shared five game resource already exists; return that
	@PostMapping("/FGG")
	public EntityModel<Game> makeFGG() {
		log.info("Accessed makeFGG");
		log.info(FGG.toString());
		return EntityModel.of(FGG,
				linkTo(methodOn(PngApplication.class).makeFGG()).withSelfRel());
	}

	//get five game resource
	//One shared five game resource already exists; return that
	@GetMapping("/FGG")
	public EntityModel<Game> getFGG() {
		log.info("Accessed FGG");
		log.info(FGG.toString());
		return EntityModel.of(FGG,
				linkTo(methodOn(PngApplication.class).getFGG()).withSelfRel());
	}

	//create a new guess in five game
	//return the outcome of the guess on the game
	@PutMapping("/FGG/{guess}")
	public EntityModel<Game> guessFGG(@PathVariable(value = "guess") Integer guess) {
		log.info("Accessed guess FGG");
		log.info("Guess: " + guess.toString());
		Game gameCopy = FGG.copy();
		FiveGame.doGame(gameCopy, guess);
		return EntityModel.of(gameCopy,
				linkTo(methodOn(PngApplication.class).guessFGG(guess)).withSelfRel());
	}


	@PostMapping("/PNG")
	public EntityModel<Game> makePNG(@AuthenticationPrincipal OAuth2AuthenticatedPrincipal principal) {
		log.info("User '" + principal.getAttribute("login") + "' Accessed makePNG");
		//Get user by given id
		AccountHolder user = makeOrGetUser(principal.getAttributes());//accountHolderRepository.findByUid(uid);

		if(user == null) {
			log.info("user not found");
			throw new ResponseStatusException(HttpStatus.valueOf(404));
		} else {
			log.info("user found.");
		}

		//create game
		Game game = new Game(new Random().nextInt(Game.MAX_NUM - Game.MIN_NUM + 1) + Game.MIN_NUM);
		game.setOwner(user);

		game = gameRepository.save(game);


		return EntityModel.of(game,
				linkTo(methodOn(PngApplication.class).getPNG(principal, game.getGid())).withSelfRel());
	}

	@GetMapping(value = "/PNG/{gid}")
	public EntityModel<Game> getPNG(@AuthenticationPrincipal OAuth2AuthenticatedPrincipal principal,
									  @PathVariable(value = "gid") Long gid) {

		log.info("User '" + principal.getAttribute("login") + "' Accessed getPNG");

		Integer uid = principal.getAttribute("id");
		Game game = gameRepository.findByGid(gid);
		if(game == null || !game.getOwner().getUid().equals(uid)) {
			throw new ResponseStatusException(HttpStatus.valueOf(404));
		}

		return EntityModel.of(game,
				linkTo(methodOn(PngApplication.class).getPNG(principal, game.getGid())).withSelfRel());
	}

	@PutMapping(value ="/PNG/{gid}/{guess}")
	public EntityModel<Game> guessPNG(@AuthenticationPrincipal OAuth2AuthenticatedPrincipal principal,
									  @PathVariable(value = "gid") Long gid,
									  @PathVariable(value = "guess", required = false) Integer guess) {
		log.info("User '" + principal.getAttribute("login") + "' Accessed guessPNG");

		Integer uid = principal.getAttribute("id");

		Game game = gameRepository.findByGid(gid);
		if(game == null || !game.getOwner().getUid().equals(uid)) {
			throw new ResponseStatusException(HttpStatus.valueOf(404));
		}
		//If there is a guess, apply it.
		NameNumGame.doGame(game, guess, game.getOwner().getName());

		return EntityModel.of(game,
				linkTo(methodOn(PngApplication.class).guessPNG(principal, game.getGid(), guess)).withSelfRel());
	}

	//@PostMapping("/new_user")
	public AccountHolder makeOrGetUser(Map<String, Object> attributes) {

		//if the user exists, return them. else make a new user
		AccountHolder user = accountHolderRepository.findByUid((int) attributes.get("id"));
		if(user != null) {
			log.info("User '" + attributes.get("login").toString() + "' Exists");
			return user;
		}
		log.info("User '" + attributes.get("login").toString() + "' did not exist. Was created.");
		return accountHolderRepository.save(new AccountHolder((String) attributes.get("login"), (int) attributes.get("id")));
	}

	@GetMapping("/user")
	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		return principal.getAttributes();
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}
}

