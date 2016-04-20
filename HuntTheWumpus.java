//Hunt the Wumpus program
//Programmer: Jonathan Phoun

import java.io.*;
import java.util.*;

public class HuntTheWumpus
{
	//global variables
	static int arrowCount;
	static int spiderRoom1;
	static int spiderRoom2;
	static int bottomlessPit1;
	static int bottomlessPit2;
	static int wumpusRoom;
	static int supplyRoom;
	static boolean hasUsedArrows=false;
	static Random mixer= new Random();
	static Scanner input= new Scanner(System.in);
	
	
	public static void main(String[] args)
	throws IOException, InterruptedException
	{
		wumpusStart();
	}
	
	
	/**randomizes and assigns endgames and others conditions to rooms */
	public static Room[] setRooms()
	throws IOException
	{
	// open cave file
	Scanner caveLayout=new Scanner(new FileReader("layout.txt"));
	
	// read cave file
	int n=caveLayout.nextInt();
	Room [] cave=new Room[n];
	for(int i=0; i<cave.length; i++)
		cave[i]=new Room(caveLayout);
	
	int[] assignRoom = new int[cave.length];
	for(int i=0; i<cave.length-1; i++)
	{
		assignRoom[i]=i+2;
	}
	
	assignRoom= shuffleArray(assignRoom);
	
	wumpusRoom=assignRoom[0];
	spiderRoom1=assignRoom[1];
	spiderRoom2=assignRoom[2];
	bottomlessPit1=assignRoom[3];
	bottomlessPit2=assignRoom[4];
	supplyRoom=assignRoom[5];
	return cave;
	}
	
	public static int[] shuffleArray(int[] array)
		{
		for(int i=0; i<array.length-1; i++)
		{
			int randomPos = mixer.nextInt(array.length-2);
			int temp = array[i];

			array[i] = array[randomPos];
			array[randomPos] = temp;
		}
		return array;
		}
	
	/** start of game, asks player what they want to do */
	public static void wumpusStart()
	throws IOException, InterruptedException
	{
		Room [] cave = setRooms();
		arrowCount=3;
		int currentRoom=1;
		System.out.println("Welcome to Hunt the Wumpus!");
		wumpusTurn(currentRoom, cave);
	}
	
	
	/** returns true if wumpus is in the current room */
	public static boolean wumpusCheck(int currentRoom)
	{
		if(currentRoom==wumpusRoom){return true;}
		else{return false;}
	}
	
	/** returns true if pit is in the current room */
	public static boolean pitCheck(int currentRoom)
	{
		if(currentRoom==bottomlessPit1 || currentRoom==bottomlessPit2){return true;}
		else {return false;}
	}
	
	/** returns true if spiders are in the current room */
	public static boolean spiderCheck(int currentRoom)
	{
		if(currentRoom==spiderRoom1 || currentRoom==spiderRoom2){return true;}
		else {return false;}
	}
	
	/** returns true if arrows are in the current room */
	public static boolean supplyCheck(int currentRoom)
	{
		if(currentRoom==supplyRoom){return true;}
		else {return false;}
	}
	
	/** executes next turn ands asks user what they want to do */
	public static void wumpusTurn(int currentRoom, Room[] cave)
	throws IOException, InterruptedException
	{
		String a="";
		int responseRoom;
		
		//displays current room player is in
		System.out.println("You are in room "+currentRoom+".");
		//number of arrows left
		System.out.println("You have "+arrowCount+" arrows.");
		//room description
		System.out.println(cave[currentRoom-1].description);
		//adjacent rooms
		System.out.println("There are tunnels to "+cave[currentRoom-1].adj1+", "+cave[currentRoom-1].adj2+", "+cave[currentRoom-1].adj3+".");
		
		//check for obstacles
		if(wumpusCheck(cave[currentRoom-1].adj1) || wumpusCheck(cave[currentRoom-1].adj2) || wumpusCheck(cave[currentRoom-1].adj3))
		{
			System.out.println("You smell some nasty Wumpus.");
		}
		
		if(pitCheck(cave[currentRoom-1].adj1) || pitCheck(cave[currentRoom-1].adj2) || pitCheck(cave[currentRoom-1].adj3))
		{
			System.out.println("There is a black pool of water in the corner.");
		}
			
		if(spiderCheck(cave[currentRoom-1].adj1) || spiderCheck(cave[currentRoom-1].adj2) || spiderCheck(cave[currentRoom-1].adj3))
		{
			System.out.println("You hear a faint clicking noise.");
		}
		
		System.out.println("Your options are to move (m) or shoot (s). What will it be?");
		a=input.next();
		
		//if player chooses to move
		if(a.equals("m"))
		{
			wumpusMove(currentRoom, cave);
		}
		//if player chooses to shoot
		else if(a.equals("s"))
		{
			shooter(currentRoom, cave);
		}
		else
		{
			System.out.println("What you're trying to do is illogical.");
			wumpusTurn(currentRoom, cave);
		}
	}
	
	
	/** player chooses what room they want to go to */
	public static void wumpusMove(int currentRoom, Room[] cave)
	throws IOException, InterruptedException
	{
		int responseRoom=-1;
		
		//lists adjacent rooms that player can choose
		System.out.println("Which room? ("+cave[currentRoom-1].adj1+", "+cave[currentRoom-1].adj2+", or "+cave[currentRoom-1].adj3+")");
		responseRoom=input.nextInt();
		
		if(responseRoom==(cave[currentRoom-1].adj1) || responseRoom==(cave[currentRoom-1].adj2) || responseRoom==(cave[currentRoom-1].adj3))
		{
			move(responseRoom, cave);
		}
		else
		{
			System.out.println("You can't traverse to that cave.");
			wumpusMove(currentRoom, cave);
		}
	}

	/** this is where the player actually moves to a room */
	public static void move(int currentRoom, Room[] cave)
	throws IOException, InterruptedException
	{
		System.out.println("You are moving to "+currentRoom+".");
		
		//check supply room
		if(supplyCheck(currentRoom))
		{
			if(hasUsedArrows==false)
			{
				System.out.println("You come across a room with extra arrows. You replenish your arrows.");
				arrowCount=3;
				hasUsedArrows=true;
			}
		}
		
		/** the losing conditions of the game, otherwise, start turn again */
		if(wumpusCheck(currentRoom))
		{
			System.out.println("The Wumpus got you!");
			endGame();
		}
		else if(pitCheck(currentRoom))
		{
			System.out.println("You fell down a bottomless pit!");
			endGame();
		}
		else if(spiderCheck(currentRoom))
		{
			System.out.println("You were attacked by spiders!");
			endGame();
		}
		else {
			wumpusTurn(currentRoom, cave);
		}
	}
	
	/** player shoots arrow, if they hit the wumpus, they win */
	public static void shooter(int currentRoom, Room[] cave)
	throws IOException, InterruptedException
	{
		int responseRoom;
		
		if(arrowCount==0)
		{
			System.out.println("Oh no! You've run out of arrows.");
			wumpusTurn(currentRoom, cave);
		}
		
		System.out.println("Which room? ("+cave[currentRoom-1].adj1+", "+cave[currentRoom-1].adj2+", or "+cave[currentRoom-1].adj3+")");
		responseRoom=input.nextInt();
		
		if(responseRoom==(cave[currentRoom-1].adj1))
		{
			if(wumpusCheck(cave[currentRoom-1].adj1))
			{
				winner();
			}
		}
		
		else if(responseRoom==(cave[currentRoom-1].adj2))
		{
			if(wumpusCheck(cave[currentRoom-1].adj2))
			{
				winner();
			}
		}
		
		else if(responseRoom==(cave[currentRoom-1].adj3))
		{
			if(wumpusCheck(cave[currentRoom-1].adj3))
			{
				winner();
			}
		}
		else
		{
			System.out.println("You can't shoot in that room.");
			shooter(currentRoom, cave);
		}
		System.out.println("The arrow flies into room " +responseRoom+"...");
		arrowCount--;
		System.out.println("The arrow doesn't hit anything and is lost.");
		wumpusTurn(currentRoom, cave);
	}
	
	/** player wins the game and is asked if they want to play again */
	public static void winner()
	throws IOException, InterruptedException
	{
		String a;
		System.out.println("You arrow brings down the Wumpus!");
		System.out.println("You have won the game!");
		System.out.println("Play again? y or n");
		a=input.next();
		if(a.equals("y"))
		{
			{wumpusStart();}
		}
		else 
		{}
	}
	
	/** player loses and is asked if they want to play again */
	public static void endGame()
	throws IOException, InterruptedException
	{
		String a;
		System.out.println("GAME OVER");
		System.out.println("Try again? y or n");
		a=input.next();
		if(a.equals("y"))
		{
			{wumpusStart();}
		}
		else 
		{}
	}
}


/* 
text file
10
1 2 6 10
A wooden sign reads "Beware of the Wumpus!"
2 1 3 7
There is a black pool of water in the corner.
3 2 4 8
You see a Tyrannosaurus Rex fossil embedded in the wall.
4 3 5 9
There is an empty Diet Rite can here.
5 4 6 10
You almost step on a broken cellular phone.
6 1 5 7
A couple of evil rats stare at you from under a pile of rocks.
7 2 6 8
You find a Spanish doubloon on the floor.
8 3 7 9
The ceiling is very low and you have to stoop.
9 4 8 10
You step on a slippery spot, slip, and fall on your keester.
10 1 5 9
You get a strong sense of deja vu.
*/

/*Welcome to Hunt the Wumpus!
You are in room 1.
You have 3 arrows.
A wooden sign reads "Beware of the Wumpus!"
There are tunnels to 2, 6, 10.
There is a black pool of water in the corner.
Your options are to move (m) or shoot (s). What will it be?
m
Which room? (2, 6, or 10)
6
You are moving to 6.
You are in room 6.
You have 3 arrows.
A couple of evil rats stare at you from under a pile of rocks.
There are tunnels to 1, 5, 7.
You smell some nasty Wumpus.
There is a black pool of water in the corner.
Your options are to move (m) or shoot (s). What will it be?
s
Which room? (1, 5, or 7)
6
You can't shoot in that room.
Which room? (1, 5, or 7)
5
You arrow brings down the Wumpus!
You have won the game!
Play again? y or n*/


