package com.game.PNG;


import java.lang.Math;

public class NameNumGame {

    public static final Integer MAX_NAME_LEN = 26;
    private static final Integer min = Game.MIN_NUM;
    private static final Integer max = Game.MAX_NUM;
    private static final String DEFAULT_NAME = "DEFAULT";

   public static void doGame(Game game, Integer guess, String theName) {
	
 	//response.setContentType("text/html; charset=UTF-8");
	//PrintWriter out = response.getWriter();

	//ignore any entered names if the session was already made
	String name = fixName(theName);

	Integer goalnum = game.getGoalnum();
	
	if(guess != null)
	{
		try{
			Integer num = guess;
			//num is a valid guess, 
			//Do the name functions to it, then
			//check if it is the correct guess
			System.out.println(name);
			Integer alteredNum = applyNameFunctions(num, name);

			//out.println("Goal:       " + goalNum.toString());
			//out.println("Your guess: " + alteredNum.toString());
			game.setLastguess(alteredNum);

			if(alteredNum.toString().equals(goalnum.toString()))
			{
				//out.println("Wow! The answer was %s!, You're amazing!!!".formatted(num));
				//session.invalidate(); //The game for this user is over
				//out.close();
				game.setVictory(true);
				return;
			}
			else
			{
				//out.println(alteredNum.toString() + " != " + goalNum.toString());
				//out.close();
				game.setVictory(false);
				return;
			}
		} catch(NumberFormatException e) {
			; //Return if num is not an integer
		}

	}	
	//Return if no paramter num
	//out.println("invalid guess:");

	//out.close();
	
   }
   
   //Returns true if the given string represents a valid name, returns false otherwise
   public static boolean validateName(String name)
   {
        if(name == null){return false;} //null names not allowed
        return  name.length() <= MAX_NAME_LEN && name.matches("[a-zA-Z]+");
   }

   public static Integer applyNameFunctions(Integer num, String name)
   {
	Integer result = num;

	for(char letter : name.toCharArray())
	{
		switch(letter)
		{
			case 'A':
                result = func_A(result);
				break;
			case 'B':
				result = func_B(result);
				break;
			case 'C':
				result = func_C(result);
				break;
			case 'D':
                                 result = func_D(result);
				break;
			case 'E':
                                 result = func_E(result);
				break;
			case 'F':
                                 result = func_F(result);
				break;
			case 'G':
                                 result = func_G(result);
				break;
			case 'H':
                                 result = func_H(result);
				break;
			case 'I':
                                 result = func_I(result);

				break;
			case 'J':
                                 result = func_J(result);
				
				break;
			case 'K':
                                 result = func_K(result);

				break;
			case 'L':
                                 result = func_L(result);

				break;
			case 'M':
                                 result = func_M(result);

				break;
			case 'N':
                                 result = func_N(result);

				break;
			case 'O':
                                 result = func_O(result);

                                break;
                        case 'P':
                                 result = func_P(result);

                                break;
                        case 'Q':
                                 result = func_Q(result);

                                break;
                        case 'R':
                                 result = func_R(result);

                                break;
                        case 'S':
                                 result = func_S(result);

                                break;
                        case 'T':

                                 result = func_T(result);
                                break;
                        case 'U':

                                 result = func_U(result);
                                break;
                        case 'V':
                                 result = func_V(result);

                                break;
                        case 'W':
                                 result = func_W(result);

                                break;
                        case 'X':
                                 result = func_X(result);

                                break;
                        case 'Y':
                                 result = func_Y(result);

                                break;
                        case 'Z':
                                 result = func_Z(result);
				
                                break;


		    }
	    }
	    return result;
   }

   	//Adds 10
   	public static Integer func_A(Integer num)
   	{
		return num+10;
   	}

	//Below 1000; add 1000
	public static Integer func_B(Integer num)
	{
		if(num<1000)
			return num+1000;
        	return num;
   	}

    //add 32
    public static Integer func_C(Integer num)
    {
        return num+32;
    }

    //Decrement
    public static Integer func_D(Integer num)
    {
    return num-1;
    }

    //Divide by 3 if num is divisble by 3
    public static Integer func_E(Integer num)
    {
            if(num%3 == 0)
                return num/3;
            else
                return num;
    }

	//subtract 5
    public static Integer func_F(Integer num)
    {
                return num-5;
    }

    //subtract 16711935
    public static Integer func_G(Integer num)
    {
            return(num - 16711935);
    }

	//Halve the guess
    public static Integer func_H(Integer num)
    {
            return num/2;
    }
    //Increment by 1
    public static Integer func_I(Integer num)
    {
            return num+1;
    }

	//Add 128
    public static Integer func_J(Integer num)
	{
                return num+128;
	}

    //convert to kilometers
    public static Integer func_K(Integer num)
        {
                return num/1000;
        }

	//+111
    public static Integer func_L(Integer num)
        {
                return num+111;
        }

    //add 4591
    public static Integer func_M(Integer num)
        {
                return num+4591;
        }

	//Negate
    public static Integer func_N(Integer num)
        {
                return num*(-1);
        }

    //divide by 1.2
    public static Integer func_O(Integer num)
   	{
        return (int)(num/1.2);
    }

	//plus 2
    public static Integer func_P(Integer num)
    {
        return num+2;
    }

    //Add 13, call func U
	public static Integer func_Q(Integer num)
        {
                return func_U(num+13);
        }

	//subtract from maximum
    public static Integer func_R(Integer num)
    {
            return max-num;
    }

    //Swap last and second to last digit if number is > 100
    public static Integer func_S(Integer num)
    {
        if(num < 100)
            return num;
        else {
            char[] strNum = num.toString().toCharArray();
            swap(strNum, strNum.length - 2, strNum.length - 1);
            return Integer.valueOf(new String(strNum));
        }
    }

	//remove leftmost digit and add it
	public static Integer func_T(Integer num) {
        String numberStr = String.valueOf(num);

        String remainingDigits = numberStr.substring(1);
        if(remainingDigits.length() == 0)
            return num;
        Integer result = Integer.parseInt(remainingDigits);

        String leftMostDigit = numberStr.substring(0, 1);
        Integer add = Integer.parseInt(leftMostDigit);
        return result + add;
    }

    //square root
    public static Integer func_U(Integer num)
    {
        return (int)Math.sqrt(num);
    }

	//add 77
    public static Integer func_V(Integer num)
    {
        return num+77;
    }

	//+1011
    public static Integer func_W(Integer num)
    {
            return num+1011;
    }

    //add 12345
    public static Integer func_X(Integer num)
    {
		return num+12345;
    }

    //multiply by 2, divide by 3
    public static Integer func_Y(Integer num)
    {
    return (num*2)/3;
    }

	//combine result of func_A, func_B, func_C, func_D, func_E
    public static Integer func_Z(Integer num)
    {
        return func_A(func_B(func_C(func_D(num))));
    }
	public static void swap(char[] arr, int i, int j) {
	    char temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}

    //Takes a name and modifies so that it is valid for the game
    public static String fixName(String name) {
       //If the string length is 0 or the string is null, return a default string
        if(name == null || name.isEmpty()){
            return DEFAULT_NAME;
        }

       //If name is longer than 26, crop to 26
        String fixed = name;
        if(fixed.length() > MAX_NAME_LEN) {
            fixed = fixed.substring(0,MAX_NAME_LEN);
        }

        //Make the string uppercase
        fixed = fixed.toUpperCase();

        //Remove all but invalid characters
        String pattern = fixed.replaceAll("[A-Z]", "");
        return fixed.replaceAll(pattern, "");
    }
}

