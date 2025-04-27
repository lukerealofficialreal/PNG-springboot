package com.game.PNG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class NameNumGameTests {

    private Game game10000;
    private Game game1000;
    private Game game1;
    private Game game0;

    private Game[] games;

    private final Integer[] goalEdgeCases = new Integer[] {0,1,1000,10000};

    @BeforeEach
    void setUp() {
        game10000 = new Game(10000);
        game1000 = new Game(1000);
        game1 = new Game(1);
        game0 = new Game(0);

        games = new Game[] {game0, game1, game1000, game10000};
    }

    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameA_expOutput() {
        String name = "A";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {10, 11, 1010, 10010};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }

    @Test
    public void testDoGame_nameA_correctGuess() {
        String name = "A";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {-10, -9, 990, 9990};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }

    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameB_expOutput() {
        String name = "B";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {1000, 1001, 1000, 10000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }

    @Test
    public void testDoGame_nameB_correctGuess() {
        String name = "B";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {-1000, -999, 1000, 10000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }

    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameC_expOutput() {
        String name = "C";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {32, 33, 1032, 10032};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }

    @Test
    public void testDoGame_nameC_correctGuess() {
        String name = "C";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {-32, -31, 1000-32, 10000-32};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }

    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameD_expOutput() {
        String name = "D";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {-1, 0, 999, 9999};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }

    @Test
    public void testDoGame_nameD_correctGuess() {
        String name = "D";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {1, 2, 1001, 10001};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameE_expOutput() {
        String name = "E";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0, 1, 1000, 10000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }

        //Extra test cases for full path coverage
        Game[] extraGames = new Game[] {new Game(9)};
        Integer[] extraGoalNums = new Integer[] {9};
        Integer[] extraExpOut = new Integer[] {3};

        currCase = 0;
        for(Game game : extraGames){
            NameNumGame.doGame(game, extraGoalNums[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), extraGoalNums[currCase], game.getLastguess(), extraExpOut[currCase]));

            assertEquals(extraExpOut[currCase], game.getLastguess());
        }
    }

    @Test
    public void testDoGame_nameE_correctGuess() {
        String name = "E";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0, 1, 1000, 10000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }

        //Extra test cases for full path coverage
        Game[] extraGames = new Game[] {new Game(9)};
        Integer[] extraGoalNums = new Integer[] {9};
        Integer[] extraCorrectGuesses = new Integer[] {27};

        currCase = 0;
        for(Game game : extraGames){
            NameNumGame.doGame(game, extraCorrectGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), extraCorrectGuesses[currCase], game.getLastguess(), extraGoalNums[currCase]));

            assertTrue(game.getVictory());
        }
    }

    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameF_expOutput() {
        String name = "F";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {-5, -4, 995, 9995};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }

    @Test
    public void testDoGame_nameF_correctGuess() {
        String name = "F";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {5, 6, 1005, 10005};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameG_expOutput() {
        String name = "G";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0-16711935, 1-16711935, 1000-16711935, 10000-16711935};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }

    @Test
    public void testDoGame_nameG_correctGuess() {
        String name = "G";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0+16711935, 1+16711935, 1000+16711935, 10000+16711935};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameH_expOutput() {
        String name = "H";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0, 0, 500, 5000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }

    @Test
    public void testDoGame_nameH_correctGuess() {
        String name = "H";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {1, 2, 2000, 20000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameI_expOutput() {
        String name = "I";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {1,2, 1001, 10001};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }

    @Test
    public void testDoGame_nameI_correctGuess() {
        String name = "I";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {-1, 0, 999, 9999};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }

    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameJ_expOutput() {
        String name = "J";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {128,129, 1128, 10128};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameJ_correctGuess() {
        String name = "J";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {-128, -127, 1000-128, 10000-128};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameK_expOutput() {
        String name = "K";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0/1000,1/1000, 1000/1000, 10000/1000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameK_correctGuess() {
        String name = "K";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0*1000, 1*1000, 1000*1000, 10000*1000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameL_expOutput() {
        String name = "L";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0,0, 250, 2500};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameL_correctGuess() {
        String name = "L";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0*4, 1*4, 1000*4, 10000*4};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameM_expOutput() {
        String name = "M";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0+4591,1+4591, 1000+4591, 10000+4591};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameM_correctGuess() {
        String name = "M";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0-4591, 1-4591, 1000-4591, 10000-4591};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameN_expOutput() {
        String name = "N";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0,-1, -1000, -10000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameN_correctGuess() {
        String name = "N";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0, -1, -1000, -10000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameO_expOutput() {
        String name = "O";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {(int)(0/1.2), (int)(1/1.2), (int)(1000/1.2), (int)(10000/1.2)};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameO_correctGuess() {
        String name = "O";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {(int)(0*1.2), (int)(2), (int)(1000*1.2), (int)(10000*1.2)};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameP_expOutput() {
        String name = "P";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0+2,1+2,1000+2,10000+2};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameP_correctGuess() {
        String name = "P";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0-2,1-2,1000-2,10000-2};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameQ_expOutput() {
        String name = "Q";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {3,3,31,100};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameQ_correctGuess() {
        String name = "Q";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {-13, -12, 999987, 99999987};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameR_expOutput() {
        String name = "R";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {10000-0,10000-1,10000-1000,10000-10000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameR_correctGuess() {
        String name = "R";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {10000+0,10000-1,10000-1000,10000-10000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameS_expOutput() {
        String name = "S";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0, 1, 1000, 10000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameS_correctGuess() {
        String name = "S";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0, 1, 1000, 10000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameT_expOutput() {
        String name = "T";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0, 1, 1, 1};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameT_correctGuess() {
        String name = "T";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0, 1, 1999, 19999};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameU_expOutput() {
        String name = "U";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0, 1, 31, 100};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameU_correctGuess() {
        String name = "U";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0*0,1*1,1000*1000,10000*10000};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameV_expOutput() {
        String name = "V";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0+77, 1+77, 1000+77, 10000+77};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameV_correctGuess() {
        String name = "V";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0-77,1-77,1000-77,10000-77};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameW_expOutput() {
        String name = "W";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0+1011, 1+1011, 1000+1011, 10000+1011};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameW_correctGuess() {
        String name = "W";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0-1011, 1-1011, 1000-1011, 10000-1011};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameX_expOutput() {
        String name = "X";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {0+12345, 1+12345, 1000+12345, 10000+12345};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameX_correctGuess() {
        String name = "X";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {0-12345, 1-12345, 1000-12345, 10000-12345};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameY_expOutput() {
        String name = "Y";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {(0*2)/3,(1*2)/3, (1000*2)/3, (10000*2)/3};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameY_correctGuess() {
        String name = "Y";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {(0*3)/2, (1*3)/2+1, (1000*3)/2, (10000*3)/2};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }
    //Test a game played with a name for each letter function.
    //Ensure the functions do as they should.
    //Ensure the game is beatable given any valid goalNum
    @Test
    public void testDoGame_nameZ_expOutput() {
        String name = "Z";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the goal nums as guess through doGame with the given game.
        //Ensure the function has the expected output
        Integer[] expectedOutput = new Integer[] {(0+10+32-1+1000),(1+10+32-1+1000),(1000+10+32-1),(10000+10+32-1)};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, goalEdgeCases[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, ExpectedOutput=%d"
                    .formatted(game.getGoalnum(), goalEdgeCases[currCase], game.getLastguess(), expectedOutput[currCase]));

            assertEquals(expectedOutput[currCase], game.getLastguess());

            currCase++;
        }
    }
    @Test
    public void testDoGame_nameZ_correctGuess() {
        String name = "Z";
        int currCase; //Edge cases: 0, 1, 1000, 10000

        //Run the correct guesses through the doGame function
        //Ensure they result in victory
        Integer[] correctGuesses = new Integer[] {(0-10-32+1-1000),(1-10-32+1-1000),(1000-10-32+1-1000),(10000-10-32+1)};

        currCase = 0;
        for(Game game : games) {
            NameNumGame.doGame(game, correctGuesses[currCase], name);

            System.out.println("Goal=%d, Guess=%d, ModGuess=%d, expectedOutput=%d"
                    .formatted(game.getGoalnum(), correctGuesses[currCase], game.getLastguess(), goalEdgeCases[currCase]));

            assertTrue(game.getVictory());

            currCase++;
        }
    }

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
