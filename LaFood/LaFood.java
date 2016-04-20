import java.io.*;
import java.util.*;

/** executes program */

public class LaFood
{
	public static void main(String[]args)
		throws IOException
		{
			Simulate driver= new Simulate();
			driver.start();
		}
}

/* 
*** Welcome to La Food Restaurant ***
Please wait at the bar and enjoy some drinks.
 Party Merlin of 3 people..
Please wait at the bar and enjoy some drinks.
 Party Arthur Pendragon of 2 people..
Table for Merlin!
Please wait at the bar and enjoy some drinks.
 Party Sir Lancelot of 2 people..
Table for Arthur Pendragon!
Please wait at the bar and enjoy some drinks.
 Party The Green Knight of 3 people..
Table for Sir Lancelot!
Simulation is now complete!
The average waiting time was: 7.29.
The following parties never got a seat:
 Party The Green Knight of 3 people.
 
 text file
A 3 3 Merlin
A 8 2 Arthur Pendragon
T 10
A 12 2 Sir Lancelot
T 15
A 17 3 The Green Knight
T 20
Q
 */
 

