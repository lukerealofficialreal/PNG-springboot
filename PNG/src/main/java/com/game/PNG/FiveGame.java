package com.game.PNG;

public class FiveGame {
   
   public static void doGame(Game game, Integer guess) {
	
	if(guess != null)
	{
		try{
			Integer num = guess;
			//num is a valid guess, check if it is the correct guess
			game.setLastguess(num);
			if(num.equals(game.getGoalnum()))
			{
				game.setVictory(true);
				return;
			}
			else
			{
				game.setVictory(false);
				return;
			}
		} catch(NumberFormatException e) {
		       ;	//Return if num is not an integer
		}

	}	
	//Return if no parameter num
	game.setLastguess(null);
	return;
   }
}
