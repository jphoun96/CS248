/** @author Jonathan Phoun
defines camper object for main program
*/

import java.io.*;
import java.util.*;

public class Camper implements Comparable
{
	int age;
	char gender;
	String name;

	/** basic constructor  */
	public Camper()
	{
		age = 0;
		gender = 'A';
		name = "";
	}
  
	/**
	@param a arrival time
	@param g gender (M or F)
	@param n name of camper
	*/
	public Camper(int a, char g, String n)
	{
		age = a;
		gender = g;
		name = n;
	}
  
	
	public Camper(Scanner s)
	{
		name = s.next();
		age = s.nextInt();
		gender = s.next().charAt(0);
	}
	
	public int compareTo(Object x)
	{
		if (x instanceof Camper)
		{
			Camper xCamper = (Camper) x;
			return this.name.compareTo(xCamper.name);
		}
		else
		{
			System.out.println("Error not a camper!");
		}
		return 0; 
 }

	/** @return age of the camper */
	public int getAge()
		{ 
			return age; 
		}
	/** @return gender of the camper */
	public int getGender()
		{ 
			return gender; 
		}
	/** @return name of the camper */
	public String getName()
		{ 
			return name; 
		}
	
	public String toString()
	{
		return ("Name: "+name+", Age: "+age+", Gender: "+gender);
	}

}