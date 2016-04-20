import java.io.*;
import java.util.*;

class Fishmain
{
	public static void sharkvisit(Fish [] A)
	{
		int target;
		target=(int)(A.length*Math.random());
		A[target].sharkAttack();
	}
	
	public static void main(String[]args)
	  throws IOException
	{
		Fish f;
		f=new Fish("Nemo","clownfish",
		  7,"orange");
		Fish f2=new Fish("Angela","angelfish",
		  5,"blue");
		System.out.println(f+"\n"+f2);
		
		System.out.println(f.count);
		System.out.println(Fish.count);
		
		System.out.println(
		  "The names are "+f.getName()+
		    " and "+f2.getName() );
			
		System.out.println("Oh no, a shark!");
		f.sharkAttack();
		System.out.println(f+"\n"+f2+"\n");
		
		// read fish from a file
		Scanner fishfile=new Scanner(
		  new FileReader("fishfile.txt"));
		
		int n;
		n=fishfile.nextInt(); // get # of fish
		
		// array of fish
		Fish [] school;
		school=new Fish[n];
		
		for(int i=0; i<school.length; i++)
		{
			school[i] = new Fish(fishfile);
			System.out.println(Fish.count);
		}
		
		for(int i=0; i<school.length; i++)
		{
			System.out.println(school[i]);
		}
		sharkvisit(school);
		System.out.println("A shark visits the school!");
		for(int i=0; i<school.length; i++)
		{
			System.out.println(school[i]);
		}
	}
}

