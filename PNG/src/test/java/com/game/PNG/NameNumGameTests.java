package com.game.PNG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class NameNumGameTests {




    @Test
    public void testValidateName() {
        String goodName1 = "robert";
        String goodName2 = "a";
        String goodName3 = "abcdefghijklmnopqrstuvwxyz";

        assertTrue(NameNumGame.validateName(goodName1));
        assertTrue(NameNumGame.validateName(goodName2));
        assertTrue(NameNumGame.validateName(goodName3));

        String badName1 = "robert ";
        String badName2 = "r0bert";
        String badName3 = "abcdefghijklmnopqrstuvwxyzz";
        String badName4 = "";

        assertFalse(NameNumGame.validateName(badName1));
        assertFalse(NameNumGame.validateName(badName2));
        assertFalse(NameNumGame.validateName(badName3));
        assertFalse(NameNumGame.validateName(badName4));
    }

    @Test
    //Test that the swap method successfully swaps two indices in an array
    public void testSwap() {
        char[] arr1 = new char[] {'1','2','3','4','5','6','7','8'};

        //Accomplished by swapping index 2 with index 6
        char[] goal1 = new char[] {'1','2','7','4','5','6','3','8'};

        NameNumGame.swap(arr1, 2, 6);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(goal1));

        assertArrayEquals(arr1, goal1);

        char[] arr2 = new char[] {'1','2','3','4','5','6','7','8'};

        //accomplished by swapping the first 4 indices with the last 4 indices
        char[] goal2 = new char[] {'8','7','6','5','4','3','2','1'};

        for(int i = 0; i < arr2.length/2; i++) {
            NameNumGame.swap(arr2, i, (arr2.length-1)-i);
        }

        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(goal2));

        assertArrayEquals(arr2, goal2);
    }

}
