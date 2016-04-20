import java.io.*;
import java.util.*;

class Guess
{
	static Scanner cin =
	 new Scanner(System.in);

	static void welcome()
	{
		System.out.println("**WELCOME TO THE GUESSING GAME!**");
		System.out.println("I have a number between 1 and 100. Can you guess it?");
	}
	
	static void insult()
	{
	int insult;
	insult= (int)(1+5*Math.random());

	if (insult==1)
		System.out.println("such a noob!");
	else if (insult==2)
		System.out.println("you scrublord!");
	else if (insult==3)
		System.out.println("get outta here!");
	else if (insult==4)
		System.out.println("how did you get into college?");
	else if (insult==5)
		System.out.println("bet your parents are proud of you!");
	}
	
	static void game()
	{
		int number;
		number= (int)(1+100*Math.random());
		
		welcome();
		int guess;
		
		do
		{
			System.out.println("Enter your guess.");
			guess=cin.nextInt();
			System.out.println(guess);
			
			if(guess>number)
			{
				System.out.println("Too high, ");
				insult();
			}
			else if(guess<number)
			{
				System.out.println("Too low, ");
				insult();
			}
			else if(guess==number)
			{
				System.out.println("You guessed correctly");
			}
		}while(guess!=number);
		
	}
	 
	 public static void main(String [] args)
	 {
		char response;
		do
		{
		game(); //game function
		System.out.println("Would you like to play again?");
		System.out.println("Enter 'y' or 'n'.");
		response=cin.next().charAt(0);
		System.out.println(response);
		}while(response=='y');
		System.out.println("Thanks for playing!");
	 }
}


/*WELCOME TO THE GUESSING GAME!
I have a number between 1 and 100. Can you guess it?
Enter your guess.
63
63
Too low,
how did you get into college?
Enter your guess.
15
15
Too low,
get outta here!
Enter your guess.
45
45
Too low,
such a noob!
Enter your guess.
58
58
Too low,
get outta here!
Enter your guess.
60
60
Too low,
such a noob!
Enter your guess.
69
69
Too low,
bet your parents are proud of you!
Enter your guess.
70
70
Too low,
bet your parents are proud of you!
Enter your guess.
72
72
Too low,
bet your parents are proud of you!
Enter your guess.
73
73
Too low,
such a noob!
Enter your guess.
74
74
Too low,
how did you get into college?
Enter your guess.
80
80
You guessed correctly
Would you like to play again?
Enter 'y' or 'n'.
n
n
Thanks for playing!*/
