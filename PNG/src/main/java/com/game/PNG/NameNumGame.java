package com.game.PNG;


import java.util.Random;
import java.lang.Math;

public class NameNumGame {

   public static final Integer min = 0;
   public static final Integer max = 10000;
   public static final Integer maxNameLen = 26;
   
   public static void doGame(Game game, Integer guess, String theName) {
	
 	//response.setContentType("text/html; charset=UTF-8");
	//PrintWriter out = response.getWriter();
		
	//ignore any entered names if the session was already made
	String name = theName.toUpperCase();

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
	return  name.length() <= maxNameLen && name.matches("[a-zA-Z]+");
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
		//Add extra to the overflow so that all possible integer values are guessable
		result = (result%max + (num/max))%max;
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

        //Compute hypontenuse
        public static Integer func_C(Integer num)
        {
		Integer C = (int)Math.sqrt((num*num) + (num*num)); 
                return C;
        }

	//Decrement and divide by 4
        public static Integer func_D(Integer num)
        {
		return (num--)/4;
        }
        //multiply by euler's number
        public static Integer func_E(Integer num)
        {
                return (int)(num*Math.E);
        }

	//Fraction into thirds
        public static Integer func_F(Integer num)
        {
                return num/3;
        }
        //Add subtract all colors but green
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
                return ++num;
        }

	//Add 128, Jump to M
        public static Integer func_J(Integer num)
	{
                return func_M(num+128);
	}
        //convert to kilometers
        public static Integer func_K(Integer num)
        {
                return num/1000;
        }

	//Left shift by 1
        public static Integer func_L(Integer num)
        {
                return num<<1;
        }
        //Multiply by 1.2
        public static Integer func_M(Integer num)
        {
                return (int)(num*1.2);
        }

	//Negate
        public static Integer func_N(Integer num)
        {
                return num*(-1);
        }
        //Check out of bounds
        public static Integer func_O(Integer num)
   	{
		if(num < min)
			return num+1000;
		if(num > max)
			return num-1000;
                return num+10;
        }

	//Partition	
        public static Integer func_P(Integer num)
        {
		char[] strNum = num.toString().toCharArray();
		int low = 0;
		int high = strNum.length-1;
		char pivot = strNum[high];
			
		int stab = low - 1;;
		for (int j = low; j <= high; j++) {
            		if (strNum[j] < pivot) {
                	swap(strNum, ++stab, j);
            		}	
        	}
		swap(strNum, ++stab, high);
                Integer result = Integer.valueOf(new String(strNum));
		return num;
        }

        //Add 5, call func U
	public static Integer func_Q(Integer num)
        {
                return func_U(num+5);
        }

	//Right shift
        public static Integer func_R(Integer num)
        {
                return num>>1;
        }
        //Swap first and last digit
        public static Integer func_S(Integer num)
        {
		char[] strNum = num.toString().toCharArray();
		swap(strNum, 0, strNum.length-1);
                return Integer.valueOf(new String(strNum));
        }

	//Total the value of each digit
	public static Integer func_T(Integer num)
        {
                char[] strNum = num.toString().toCharArray();
		Integer result = 0;
		for(char character : strNum)
		{
			result += (int)(character);
		}
                return result + num;
        }
        //Unary operator
        public static Integer func_U(Integer num)
        {
		if(num > 2000)
		{
			return (int)(Math.log(num));
		}	
		else if ((num < 1000) && (num > 1))
		{
			return (int)Math.exp(num);
		}
		else
			return num;
        }

	//Variance
        public static Integer func_V(Integer num)
        {
                return num+(new Random().nextInt(2 - 0 + 1) - 1);
        }

	//Double U
        public static Integer func_W(Integer num)
        {
                return func_U(func_U(num));
        }

        //times 37
        public static Integer func_X(Integer num)
        {
		return num*37;
        }

        //Y
        public static Integer func_Y(Integer num)
        {
		return (num*77/2)>>>1;
        }
	//Z
        public static Integer func_Z(Integer num)
        {
                char[] strNum = num.toString().toCharArray();
                Integer result = -45;
                for(char character : strNum)
                {
                        result += Integer.valueOf(character);
                }
		result += 2 + func_Y(num) + func_C(num) - num;
                return result;
        }
	public static void swap(char[] arr, int i, int j) {
	    char temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}

