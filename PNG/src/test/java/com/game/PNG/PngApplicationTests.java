package com.game.PNG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PngApplication.class)
class PngApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockitoBean
	private GameRepository gameRepository;

	@MockitoBean
	private AccountHolderRepository accountHolderRepository;

	Game FGG;

	Game newGame;
	Game midGame;
	AccountHolder robert;
	AccountHolder mildred;

	@BeforeEach
	public void setUp() throws Exception {
		FGG = new Game(5);

		newGame = new Game(1000);
		newGame.setGid(1L);

		robert = new AccountHolder("robert", 1);
		robert.setUid(1);

		newGame.setOwner(robert);
		robert.putGame(newGame);

		mildred = new AccountHolder("mildred", 2);
		mildred.setUid(2);
		midGame = new Game(123,null,40,false, mildred);
		midGame.setGid(2L);
		mildred.putGame(midGame);
		when(gameRepository.findByGid(1))
				.thenReturn(newGame);
		when(gameRepository.findByGid(2))
				.thenReturn(midGame);
		when(accountHolderRepository.findByUid(1))
				.thenReturn(robert);
		when(accountHolderRepository.findByUid(2))
				.thenReturn(mildred);
		when(accountHolderRepository.save(Mockito.any(AccountHolder.class))).thenReturn(robert);
		when(gameRepository.save(Mockito.any(Game.class))).thenReturn(newGame);
	}

	@Test
	public void testHello() throws Exception {
		String helloOutputDefault = "Hello World!";

		mvc.perform(get("/hello")
						.with(oauth2Login()
						.attributes(attrs -> {
							attrs.put("id", 1); // Simulate GitHub ID
							attrs.put("login", "robert");
						})
				).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", equalTo(helloOutputDefault)));
	}

	@Test
	public void testMakeFGG() throws Exception {
		mvc.perform(post("/FGG")
						.with(csrf())
						.with(oauth2Login()

								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo(FGG.getGid())))
				.andExpect(jsonPath("$['goalnum']", equalTo(FGG.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(FGG.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(FGG.getLastguess())))
				.andExpect(jsonPath("$['owner']", equalTo(null)))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/FGG")));
	}

	@Test
	public void testGetFGG() throws Exception {
		mvc.perform(get("/FGG")
						.with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo(FGG.getGid())))
				.andExpect(jsonPath("$['goalnum']", equalTo(FGG.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(FGG.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(FGG.getLastguess())))
				.andExpect(jsonPath("$['owner']", equalTo(null)))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/FGG")));
	}

	@Test
	public void testGuessFGG() throws Exception {
		//Guess incorrectly
		Game incorrect = FGG.copy();
		incorrect.setLastguess(4);

		mvc.perform(put("/FGG/4")
						.with(csrf())
						.with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo(incorrect.getGid())))
				.andExpect(jsonPath("$['goalnum']", equalTo(incorrect.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(incorrect.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(incorrect.getLastguess())))
				.andExpect(jsonPath("$['owner']", equalTo(null)))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/FGG/4")));

		//Guess correctly
		Game correct = FGG.copy();
		correct.setLastguess(5);
		correct.setVictory(true);

		mvc.perform(put("/FGG/5")
						.with(csrf())
						.with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo(correct.getGid())))
				.andExpect(jsonPath("$['goalnum']", equalTo(correct.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(correct.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(correct.getLastguess())))
				.andExpect(jsonPath("$['owner']", equalTo(null)))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/FGG/5")));

		//Guess illegally
		mvc.perform(put("/FGG/N")
						.with(csrf())
						.with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testMakePNG() throws Exception {
		//Test valid user robert
		mvc.perform(post("/PNG")
						.with(csrf())
						.with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo((int) newGame.getGid().longValue())))
				.andExpect(jsonPath("$['goalnum']", equalTo(newGame.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(newGame.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(newGame.getLastguess())))
				.andExpect(jsonPath("$['owner']['uid']", equalTo((int) robert.getUid().longValue())))
				.andExpect(jsonPath("$['owner']['name']", equalTo(robert.getName())))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/PNG/%d".formatted(newGame.getGid()))));
	}
	@Test
	public void testGetPNG() throws Exception {
		//Test valid user robert
		mvc.perform(get("/PNG/%d".formatted(newGame.getGid())).with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo((int)newGame.getGid().longValue())))
				.andExpect(jsonPath("$['goalnum']", equalTo(newGame.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(newGame.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(newGame.getLastguess())))
				.andExpect(jsonPath("$['owner']['uid']", equalTo((int)robert.getUid().longValue())))
				.andExpect(jsonPath("$['owner']['name']", equalTo(robert.getName())))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/PNG/%d".formatted(newGame.getGid()))));

		//Test invalid Game
		mvc.perform(get("/PNG/9").with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

		//Test illegal game
		mvc.perform(get("/PNG/game1").with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testGuessPNG() throws Exception {
		//Test valid user robert, valid game newGame, incorrect guess
		int guess = 100;

		Game incorrect = newGame.copy();
		incorrect.setLastguess(257);
		incorrect.setVictory(false);

		mvc.perform(put("/PNG/%d/%d".formatted(incorrect.getGid(),guess)).with(csrf()).with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo((int) incorrect.getGid().longValue())))
				.andExpect(jsonPath("$['goalnum']", equalTo(incorrect.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(incorrect.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(incorrect.getLastguess())))
				.andExpect(jsonPath("$['owner']['uid']", equalTo((int) robert.getUid().longValue())))
				.andExpect(jsonPath("$['owner']['name']", equalTo(robert.getName())))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/PNG/%d/%d"
						.formatted(incorrect.getGid(), guess))));

		//Test valid user mildred, valid game midGame, correct guess
		guess = 5174;

		Game correct = midGame.copy();
		correct.setLastguess(123);
		correct.setVictory(true);

		mvc.perform(put("/PNG/%d/%d".formatted(correct.getGid(),guess)).with(csrf()).with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 2); // Simulate GitHub ID
									attrs.put("login", "mildred");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo((int) correct.getGid().longValue())))
				.andExpect(jsonPath("$['goalnum']", equalTo(correct.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(correct.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(correct.getLastguess())))
				.andExpect(jsonPath("$['owner']['uid']", equalTo((int) mildred.getUid().longValue())))
				.andExpect(jsonPath("$['owner']['name']", equalTo(mildred.getName())))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/PNG/%d/%d"
						.formatted( correct.getGid(), guess))));

		//Test valid user, invalid game
		guess = 34916;
		mvc.perform(put("/PNG/%d/%d".formatted(9,guess)).with(csrf()).with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

		//Test valid user, illegal game
		guess = 34916;
		mvc.perform(put("/PNG/game2/%d".formatted(guess)).with(csrf()).with(oauth2Login()
								.attributes(attrs -> {
									attrs.put("id", 1); // Simulate GitHub ID
									attrs.put("login", "robert");
								})
						)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}
}
