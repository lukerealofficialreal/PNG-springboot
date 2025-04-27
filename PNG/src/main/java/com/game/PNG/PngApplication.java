package com.game.PNG;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
		return String.format("Hello %s!", name);
	}

	//'create' a new five game resource
	//One shared five game resource already exists; return that
	@PostMapping("/FGG")
	public EntityModel<Game> makeFGG() {
		log.info(FGG.toString());
		return EntityModel.of(FGG,
				linkTo(methodOn(PngApplication.class).makeFGG()).withSelfRel());
	}

	//get five game resource
	//One shared five game resource already exists; return that
	@GetMapping("/FGG")
	public EntityModel<Game> getFGG() {
		log.info(FGG.toString());
		return EntityModel.of(FGG,
				linkTo(methodOn(PngApplication.class).getFGG()).withSelfRel());
	}

	//create a new guess in five game
	//return the outcome of the guess on the game
	@PutMapping("/FGG/{guess}")
	public EntityModel<Game> guessFGG(@PathVariable(value = "guess") Integer guess) {
		Game gameCopy = FGG.copy();
		FiveGame.doGame(gameCopy, guess);
		return EntityModel.of(gameCopy,
				linkTo(methodOn(PngApplication.class).guessFGG(guess)).withSelfRel());
	}


	@PostMapping("/PNG/{uid}")
	public EntityModel<Game> makePNG(@PathVariable(value = "uid") Long uid) {

		//Get user by given id
		//AccountHolder newUser = null;
		//if(accountHolderRepository != null) {
		AccountHolder newUser = accountHolderRepository.findByUid(uid);
		//}
		//if user is null, create a new user
		if(newUser == null) {
			log.info("user not found");
			throw new ResponseStatusException(HttpStatus.valueOf(404));
		} else {
			log.info("user found.");
		}

		//create game
		Game game = new Game(new Random().nextInt(Game.MAX_NUM - Game.MIN_NUM + 1) + Game.MIN_NUM);
		game.setOwner(newUser);

		game = gameRepository.save(game);

		//return game;

		return EntityModel.of(game,
				linkTo(methodOn(PngApplication.class).getPNG(game.getOwner().getUid(), game.getGid())).withSelfRel());
		//linkTo(methodOn(EmployeeController.class).getAllEmployees()).withRel("employees"));;;
	}

	@GetMapping(value = "/PNG/{uid}/{gid}")
	public EntityModel<Game> getPNG(@PathVariable(value = "uid") Long uid,
									  @PathVariable(value = "gid") Long gid) {
		Game game = gameRepository.findByGid(gid);
		if(game == null || !game.getOwner().getUid().equals(uid)) {
			throw new ResponseStatusException(HttpStatus.valueOf(404));
		}
		//If there is a guess, apply it.
		//NameNumGame.doGame(game, guess, game.getOwner().getName());

		return EntityModel.of(game,
				linkTo(methodOn(PngApplication.class).getPNG(game.getOwner().getUid(), game.getGid())).withSelfRel());
	}

	@PutMapping(value ="/PNG/{uid}/{gid}/{guess}")
	public EntityModel<Game> guessPNG(@PathVariable(value = "uid") Long uid,
									  @PathVariable(value = "gid") Long gid,
									  @PathVariable(value = "guess", required = false) Integer guess) {
		Game game = gameRepository.findByGid(gid);
		if(game == null || !game.getOwner().getUid().equals(uid)) {
			throw new ResponseStatusException(HttpStatus.valueOf(404));
		}
		//If there is a guess, apply it.
		NameNumGame.doGame(game, guess, game.getOwner().getName());

		return EntityModel.of(game,
				linkTo(methodOn(PngApplication.class).guessPNG(game.getOwner().getUid(), game.getGid(), guess)).withSelfRel());
	}

	@PostMapping("/new_user")
	public EntityModel<AccountHolder> createAccount(@RequestParam(value = "name") String name) {

		if(!NameNumGame.validateName(name))
		{
			throw new ResponseStatusException(HttpStatus.valueOf(405));
		}

		AccountHolder newUser = new AccountHolder(name);

		//create game
		newUser = accountHolderRepository.save(newUser);

		return EntityModel.of(newUser,
				linkTo(methodOn(PngApplication.class).makePNG(newUser.getUid())).withSelfRel());
	}

}
