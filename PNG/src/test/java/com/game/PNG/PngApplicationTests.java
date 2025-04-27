package com.game.PNG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
/*
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes = PngApplication.class)
@AutoConfigureMockMvc
*/
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
	public void setUp() {
		FGG = new Game(5);

		newGame = new Game(1000);
		newGame.setGid(1L);

		robert = new AccountHolder("robert");
		robert.setUid(1L);

		newGame.setOwner(robert);
		robert.putGame(newGame);

		mildred = new AccountHolder("mildred");
		mildred.setUid(2L);
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
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", equalTo(helloOutputDefault)));
	}

	@Test
	public void testMakeFGG() throws Exception {
		mvc.perform(post("/FGG")
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
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void createAccount() throws Exception {
		//Test with a valid name
		String name = "robert";

		mvc.perform(post("/new_user")
						.param("name",name)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['uid']", equalTo((int)robert.getUid().longValue())))
				.andExpect(jsonPath("$['name']", equalTo(robert.getName())))
//				.andExpect(jsonPath("$['victory']", equalTo(incorrect.getVictory())))
//				.andExpect(jsonPath("$['lastguess']", equalTo(incorrect.getLastguess())))
//				.andExpect(jsonPath("$['owner']", equalTo(null)))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/PNG/1")));

		//Test without a name
		mvc.perform(post("/new_user")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

		//Test with a bad name
		mvc.perform(post("/new_user")
						.param("name","Robert_Gaming")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isMethodNotAllowed());
	}


	@Test
	public void testMakePNG() throws Exception {
		//Test valid user robert
		mvc.perform(post("/PNG/%d".formatted(robert.getUid()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo((int)newGame.getGid().longValue())))
				.andExpect(jsonPath("$['goalnum']", equalTo(newGame.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(newGame.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(newGame.getLastguess())))
				.andExpect(jsonPath("$['owner']['uid']", equalTo((int)robert.getUid().longValue())))
				.andExpect(jsonPath("$['owner']['name']", equalTo(robert.getName())))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/PNG/%d/%d".formatted(robert.getUid(),newGame.getGid()))));

		//Test invalid user
		mvc.perform(post("/PNG/9")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

		//Test illegal user
		mvc.perform(post("/PNG/robert")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testGetPNG() throws Exception {
		//Test valid user robert
		mvc.perform(get("/PNG/%d/%d".formatted(robert.getUid(),newGame.getGid()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo((int)newGame.getGid().longValue())))
				.andExpect(jsonPath("$['goalnum']", equalTo(newGame.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(newGame.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(newGame.getLastguess())))
				.andExpect(jsonPath("$['owner']['uid']", equalTo((int)robert.getUid().longValue())))
				.andExpect(jsonPath("$['owner']['name']", equalTo(robert.getName())))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/PNG/%d/%d".formatted(robert.getUid(),newGame.getGid()))));

		//Test invalid user
		mvc.perform(get("/PNG/9/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

		//Test invalid Game
		mvc.perform(get("/PNG/1/9")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

		//Test invalid Game & user
		mvc.perform(get("/PNG/9/9")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

		//Test illegal user
		mvc.perform(get("/PNG/robert/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

		//Test illegal game
		mvc.perform(get("/PNG/2/game1")
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

		mvc.perform(put("/PNG/%d/%d/%d".formatted(robert.getUid(), incorrect.getGid(),guess))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo((int) incorrect.getGid().longValue())))
				.andExpect(jsonPath("$['goalnum']", equalTo(incorrect.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(incorrect.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(incorrect.getLastguess())))
				.andExpect(jsonPath("$['owner']['uid']", equalTo((int) robert.getUid().longValue())))
				.andExpect(jsonPath("$['owner']['name']", equalTo(robert.getName())))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/PNG/%d/%d/%d"
						.formatted(robert.getUid(), incorrect.getGid(), guess))));

		//Test valid user mildred, valid game midGame, correct guess
		guess = 34916;

		Game correct = midGame.copy();
		correct.setLastguess(123);
		correct.setVictory(true);

		mvc.perform(put("/PNG/%d/%d/%d".formatted(mildred.getUid(), correct.getGid(),guess))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$['gid']", equalTo((int) correct.getGid().longValue())))
				.andExpect(jsonPath("$['goalnum']", equalTo(correct.getGoalnum())))
				.andExpect(jsonPath("$['victory']", equalTo(correct.getVictory())))
				.andExpect(jsonPath("$['lastguess']", equalTo(correct.getLastguess())))
				.andExpect(jsonPath("$['owner']['uid']", equalTo((int) mildred.getUid().longValue())))
				.andExpect(jsonPath("$['owner']['name']", equalTo(mildred.getName())))
				.andExpect(jsonPath("$['_links']['self']['href']", equalTo("http://localhost/PNG/%d/%d/%d"
						.formatted(mildred.getUid(), correct.getGid(), guess))));

		//Test invalid user, valid game midGame, correct guess
		guess = 34916;
		mvc.perform(put("/PNG/%d/%d/%d".formatted(9, midGame.getGid(),guess))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

		//Test valid user, invalid game
		guess = 34916;
		mvc.perform(put("/PNG/%d/%d/%d".formatted(mildred.getUid(), 9,guess))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

		//Test valid user, illegal game
		guess = 34916;
		mvc.perform(put("/PNG/%d/game2/%d".formatted(mildred.getUid(),guess))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

		//Test valid user, invalid game
		guess = 34916;
		mvc.perform(put("/PNG/mildred/%d/%d".formatted(9,guess))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());


	}


}
