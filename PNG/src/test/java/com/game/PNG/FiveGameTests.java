package com.game.PNG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FiveGameTests {

    private Game game;

    @BeforeEach
    void setUp() {
        new Game(5);
    }

    @Test
    public void testDoGame_guess5() {
        FiveGame.doGame(game, 5);
        assertEquals(5, game.getGoalnum());
        assertEquals(5, game.getLastguess());
        assertTrue(game.getVictory());
    }

    @Test
    public void testDoGame_guessBad() {
        FiveGame.doGame(game, 100);
        assertEquals(5, game.getGoalnum());
        assertEquals(100, game.getLastguess());
        assertFalse(game.getVictory());
    }

    @Test
    public void testDoGame_guessNull() {
        FiveGame.doGame(game, null);
        assertEquals(5, game.getGoalnum());
        assertNull(game.getLastguess());
        assertFalse(game.getVictory());
    }

}
