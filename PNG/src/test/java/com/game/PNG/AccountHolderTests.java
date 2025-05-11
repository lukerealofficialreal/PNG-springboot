package com.game.PNG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountHolderTests {

    private AccountHolder accountHolder;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("Robert", null);
    }

    @Test
    void testAccountHolderPojo() {
        Game game = new Game(11);

        assertEquals("Robert", accountHolder.getName());
        assertNull(accountHolder.getUid());
        assertFalse(accountHolder.userHasGame(game));

        accountHolder.setName("Steven");

        assertEquals("Steven", accountHolder.getName());

        accountHolder.putGame(game);
        assertTrue(accountHolder.userHasGame(game));
    }
}
