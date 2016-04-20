//Room class for HuntTheWumpus

import java.io.*;
import java.util.*;
//yo
public class Room
{
	int start;
	int adj1;
	int adj2;
	int adj3;
	String description;
	

	public Room(Scanner s)
	{
		start=s.nextInt();
		adj1=s.nextInt();
		adj2=s.nextInt();
		adj3=s.nextInt();
		
		s.nextLine();
		description=s.nextLine();
	}
	
	public String toString()
	{
		String a=(start+" adj1="+adj1+" adj2="+adj2+" adj3="+adj3+" description="+description);
		return a;
	}
}	
