import java.io.*;
import java.util.*;

class Strings
{
	static Scanner cin=new Scanner(
	System.in);
	
	public static void main(String [] args)
	{
		String [] list;
		list=new String[5];
		
		System.out.println("Enter 5 words: ");
		for(int i=0; i<5; i++)
		{
			list[i]=cin.next();
		}
		//print them backwards
		for(int i=list.length-1; i>=0; i--)
		{
			System.out.println(list[i]);
		}
		for(int i=0; i<list.length)
	}
}