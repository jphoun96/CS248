// Fish class
import java.io.*;
import java.util.*;

class Fish
{
	String name;
	String species;
	int fins;
	String color;
	
	// static stuff
	public static int count=0;
	
	public static void printcount()
	{
		System.out.println(count);
	}
	
	// Constructor
	public Fish(String n,String sp,int f, String c)
	{
		name=n;
		species=sp;
		fins=f;
		color=c;
		count++;
	}
	
	public Fish(Scanner file)
	{
		name=file.next();
		species=file.next();
		fins=file.nextInt();
		color=file.next();
		count++;
	}
	
	// Accessor/Observer
	public String getName()	{ return name; }
	public String getSpecies()	{ return species; }
	public String getColor()	{ return color; }
	public int getFins() { return fins; }
	
	public String toString()
	{
		return "Name="+name+
		  " Species="+species+" #fins="+fins
		  +" Color="+color;
	}
	
	// Mutator/Transformer
	
	public void sharkAttack()
	{
		if(fins>0) { fins--; }
		else { fins=0; }
	}
}