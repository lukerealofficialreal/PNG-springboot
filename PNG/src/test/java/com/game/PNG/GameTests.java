package com.game.PNG;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {
    private Game FGG;
    private Game PNG;

    @BeforeEach
    void setUp() {
        FGG = new Game(5);
        PNG = new Game(1000);
    }

    @Test
    void test5GamePojo() {
        assertNull(FGG.getGid());
        assertNull(FGG.getLastguess());
        assertEquals(5, FGG.getGoalnum());
        assertFalse(FGG.getVictory());
        assertNull(FGG.getOwner());


        FGG.setLastguess(5);
        FGG.setVictory(true);

        assertNull(FGG.getGid());
        assertEquals(5, FGG.getLastguess());
        assertEquals(5, FGG.getGoalnum());
        assertTrue(FGG.getVictory());
        assertNull(FGG.getOwner());
    }

    @Test
    void test5GameCopy() {
        Game copy = FGG.copy();
        assertEquals(copy.getGoalnum(), FGG.getGoalnum());
        assertEquals(copy.getLastguess(), FGG.getLastguess());
        assertEquals(copy.getGid(), FGG.getGid());
        assertEquals(copy.getVictory(), FGG.getVictory());
    }

    @Test
    void testPNGPojo() {
        assertNull(PNG.getGid());
        assertNull(PNG.getLastguess());
        assertEquals(1000, PNG.getGoalnum());
        assertFalse(PNG.getVictory());
        assertNull(PNG.getOwner());

        PNG.setGoalnum(6);
        PNG.setLastguess(6);
        PNG.setVictory(true);
        AccountHolder accountHolder = new AccountHolder("test");
        PNG.setOwner(accountHolder);

        assertNull(PNG.getGid());
        assertEquals(6, PNG.getLastguess());
        assertEquals(6, PNG.getGoalnum());
        assertTrue(PNG.getVictory());
        assertEquals(accountHolder, PNG.getOwner());
    }

    @Test
    void testPNGCopy() {
        Game copy = PNG.copy();
        assertEquals(copy.getGoalnum(), PNG.getGoalnum());
        assertEquals(copy.getLastguess(), PNG.getLastguess());
        assertEquals(copy.getGid(), PNG.getGid());
        assertEquals(copy.getVictory(), PNG.getVictory());
    }

    @Test
    void testToString() {
        String str = FGG.toString();
        System.out.println(str);
        assertEquals(str, "Customer[gid='null', goalnum='5', victory='false', lastguess='null', uid='null']");

        //TODO: Mock database to test uid
        /*
        str = PNG.toString();
        AccountHolder accountHolder = new AccountHolder("test");
        PNG.setOwner(accountHolder);
        System.out.println(str);
        assertEquals(str, "Customer[gid='null', goalnum='1000', victory='false', lastguess='null', uid='null']");
        */
    }
}
