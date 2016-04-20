/**
@author Jonathan Phoun
main component of Camp Posanivee program.
*/

import java.util.*;
import java.io.*;

public class CampMain
{
	public static void main(String [] args)
		throws FileNotFoundException
	{
		BST camp = new BST();
		System.out.println("Welcome to Camp Ponsaivee!");
		readIn(camp);
		
		System.out.println("Command Q: Ending program... make sure to apply plenty of sunscreen!");
	}
	
	public static void readIn(BST t)
		throws FileNotFoundException
		{
			Scanner sv = new Scanner(new FileReader("camp.txt"));
			char command;
			Camper nodeKey = new Camper(name, age, gender);
			command = sv.next().charAt(0);
			while(command != 'Q')
			{
				System.out.println();
				switch(command)
				{
					case 'H':
					System.out.println("Command: H");
					help();
					break;
					
					case 'E':
					System.out.println("Command: E");
					enroll(t, sv);
					break;
					
					case 'W':
					System.out.println("Command: W");
					nodeKey = bstLookup(t, sv);
					withdraw(t, nodeKey);
					break;
					
					case 'D':
					System.out.println("Command D");
					nodeKey = bstLookup(t, sv);
					display(nodeKey);
					break;
					
					case 'A':
					System.out.println("Command A");
					average(t);
					break;
					
					case 'L':
					System.out.println("Command L");
					alphabetize(t);
					break;
					
					case 'S':
					System.out.println("Command S");
					printCount(t);
					break;
					
					case 'P':
					System.out.println("Command P");
					preorder(t);
					break;
				}
				command = sv.next().charAt(0);
			}
		}
		
		/** @param puts list of campers' names in alphabetical order*/
		public static void alphabetize(BST t)
		{
			t.reset();
			ArrayList<String> words = new ArrayList<String>();
			while(t.hasNext())
			{
				words.add( ( (Camper)(t.getNext()) ).name);
			}
			
			Collections.sort(words);
			System.out.println("List of campers in alphbetical order:");
			
			for (String word: words)
			{
				System.out.println(" "+word);
			}
		}
		
		/** @param binary search tree function */
		public static Camper bstLookup(BST t, Scanner s)
		{
			String search = s.next();
			Camper key = new Camper(name, age, gender);
			Camper answer = (Camper)t.lookup(key);
			
			if(answer==null)
			{
				System.out.println(search+" can't be found");
				return null;
			}
			else
				return answer;
		}
		
		/** @param main menu*/
		private static void help()
		{
		System.out.println();
		System.out.println("***Camp Posanivee Command List***");
		System.out.println("H- Help: print a list of commands");
		System.out.println("E- Enroll a new camper <name, age, gender>");
		System.out.println("W- Withdraw a camper <name>");
		System.out.println("D- Display the age and gender of a camper <name>");
		System.out.println("A- Print the average age of the campers");
		System.out.println("L- List all campers names in alphabetical order");
		System.out.println("S- Print the number of boy and girl campers");
		System.out.println("P- List all campers names in preorder");
		System.out.println("Q- Quit program");
		System.out.println();
		}
		
		/** @param enroll a new camper*/
		private static void enroll(BST t, Scanner s, name)
		{
			t.insert(new Camper(name));
			System.out.println("New camper has been added.");
		}
		
		/** @param withdraw an enrolled camper*/
		private static void withdraw(BST t, Camper key)
		{
			bstLookup(name)
			t.delete(key);
			System.out.println("Camper has been withdrawn.");
		}
		
		/** @param displays key stats of campers*/
		private static void display(Camper key)
		{
			System.out.println("Name: "+key.name+"\n"+" Age: "+key.age+"\n+"+" Gender: "+key.gender);
		}
		
		/** @param calculates the average age of the campers*/
		private static void average(BST t)
		{
			t.reset();
			double ageSum=0;
			double count=0;
			while(t.hasNext())
			{
				ageSum += (double)getAge( (Camper)t.getNext() );
				count++;
			}
			
			if(count>0)
			{
				double avg = (double)(ageSum / count);
				System.out.println("The average age is: "+avg);				
			}
			else
			{
				System.out.println("Error: There are no campers.");
			}
		}
		
		/** @return retrieves age of camper */
		private static int getAge(Camper x)
		{
			return x.age;
		}
		
		/** @param prints out number of girl and boy campers*/
		private static void printCount(BST t)
		{
			int boyCount=0;
			int girlCount=0;
			t.reset();
			do
			{
				if((((Camper)(t.getNext())).gender)=="M")
					boyCount++;
				else if ((((Camper)(t.getNext())).gender)=="F")
					girlCount++;
			}while(t.hasNext());
			System.out.println("Camper count by gender:\n boys: "+boyCount+"\n girls: "+girlCount);
		}
		
		/** @param preorder function*/
		private static void preorder(BST t)
		{
			t.reset(BST.PREORDER);
			System.out.println("Preorder traversal: ");
				while(t.hasNext())
					System.out.println(" "+((Camper)(t.getNext())).name);
		}
}