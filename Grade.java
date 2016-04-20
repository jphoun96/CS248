//Programmer: Jonathan Phoun
//This program is used to compute stats from exam scores


import java.io.*;
import java.util.*;

class Grademain
{
	static Scanner cin =
	 new Scanner(System.in);
	 
	static void max(double[]list)  //maximum function
	{	
		double maximum = list[0];
		for(int i=1; i<list.length; i++)
		{
			if(list[i]>maximum)
				maximum=list[i];
		}
		System.out.println("Maximum score: "+maximum); 
	}
	
	static void min(double[]list)  //minimum function
	{	
		double minimum = list[0];
		for(int i=1; i<list.length; i++)
		{
			if(list[i]<minimum)
				minimum=list[i];
		}
		System.out.println("Minimum score: "+minimum); 
	}
	 
	static void av(double[]list)  //average function 
	{
		double sum=0;
		double average;
		for(int i=0; i<list.length; i++)
		{
		sum= sum+list[i];
		}
		average = sum/ list.length; 
		System.out.println("Average score: "+average);
	}
	
	 
	public static void main(String[]args)
	 throws IOException
	{
		//assign grades
		int gradea= 0;
		int gradeb= 0;
		int gradec= 0;
		int graded= 0;
		int gradef= 0;
		
		System.out.println("Welcome to the Exam Statistics Program!");
		System.out.println("Please enter the name of your data file: ");
		
		//reads grade from file
		String file = cin.next(); 
		Scanner gradefile= new Scanner(
		 new FileReader(file));
		 
		 int n;
		 n=gradefile.nextInt(); //gets number of grades
		 
		 //put grades in array
		 double [] list;
		 list=new double[n];
		 
		 
		 for(int i=0; i<list.length; i++)
		{
			 list[i]= gradefile.nextDouble();
	
				 if(list[i]>=90)
					 gradea++;
				 if(list[i]>=80 && list[i]<90)
					 gradeb++;
				 if(list[i]>=70 && list[i]<80)
					 gradec++;
				 if(list[i]>=60 && list[i]<70)
					 graded++;
				 if(list[i]<60)
					 gradef++;
				 System.out.println(list[i]);
		}
		
		System.out.println("Number of scores by letter grade: ");
		System.out.println("A: "+gradea);
		System.out.println("B: "+gradeb);
		System.out.println("C: "+gradec);
		System.out.println("D: "+graded);
		System.out.println("F: "+gradef);
		System.out.println("There are "+n+" scores.");
		
		max(list); //maximum function
		min(list); //minimum function
		av(list); //average function 
	}

}

/*
Welcome to the Exam Statistics Program!
Please enter the name of your data file:
esp.txt
84.0
50.0
75.0
96.0
99.0
89.0
Number of scores by letter grade:
A: 2
B: 2
C: 1
D: 0
F: 1
There are 6 scores.
Maximum score: 99.0
Minimum score: 50.0
Average score: 82.16666666666667
*/
