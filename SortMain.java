/** @programmer Jonathan Phoun */

import java.io.*;
import java.util.*;

public class SortMain
{
	/** @param time 1
	@param time 2 */
	
	public static long t1;
	public static long t2;
	
	public static void main(String[] args)
		throws IOException
	{
		System.out.println("What is the size of the list?");
		
		Scanner in= new Scanner(System.in);
		int n= in.nextInt();
		
		boolean isLong=falase;
		if(n>100)
			isLong=true;
		
		Comparable [] list= new Comparable[n];
		Comparable [] bubbleList= new Comparable[n];
		Comparable [] insertList= new Comparable[n];
		Comparable [] selectList= new Comparable[n];
		Comparable [] quickList= new Comparable[n];
		Comparable [] shellList= new Comparable[n];
		
		int temp;
		for(int i=0; i<n; i++)
		{
			temp= (int)(1+n*Math.random());
			bubbleList[i]= temp;
			insertList[i]= temp;
			selectList[i]= temp;
			quickList[i]= temp;
			shellList[i]= temp;
		}
		
		if(!isLong)
		{
			System.out.println("Original List: ");
			
			for(int i= 0;, i<bubbleList.length; i++)
			System.out.print(bubbleList[i]+", ");
			System.out.println();
		}
		
		bubble(bubbleList);
		insert(insertList);
		select(selectList);
		quick(quickList);
		shell(shellList);
	}
	
	/** @param bubbleList 
	Bubble List with Comparable array */
	public static void bubble(Comparable[] bubbleList)
	{
		t1=System.currentTimeMs();
		Sorts.bubble(bubbleList);
		t2=System.currentTimeMs();
		
		System.out.println("Bubble Sort");
		System.out.println("Time taken: "+(double)(t2-t1)+" milliseconds");
		System.out.println();
	}
	
	/** @param insertList
	Insertion sort with Comparable array*/
	public static void insert(Comparable[] insertList)
	{
		t1=System.currentTimeMs();
		Sorts.insertion(insertList);
		t2=System.currentTimeMs();
		
		System.out.println("Insertion Sort");
		System.out.println("Time taken: "+(double)(t2-t1)+" milliseconds");
		System.out.println();
	}
	
	/** @param selectList
	Selection sort with Comparable array*/
	public static void select(Comparable[] selectList)
	{
		t1=System.currentTimeMs();
		Sorts.selection(selectList);
		t2=System.currentTimeMs();
		
		System.out.println("Selection Sort");
		System.out.println("Time taken: "+(double)(t2-t1)+" milliseconds");
		System.out.println();
	}
	
	/** @param quickList
	Quick sort with Comparable array*/
	public static void quick(Comparable[] quickList)
	{
		t1=System.currentTimeMs();
		Sorts.quick(quickList);
		t2=System.currentTimeMs();
		
		System.out.println("Quick Sort");
		System.out.println("Time taken: "+(double)(t2-t1)+" milliseconds");
		System.out.println();
	}
	
	/** @param shellList
	Shell sort with Comparable array*/
	public static void shell(Comparable[] shellList)
	{
		t1=System.currentTimeMs();
		Sorts.quick(shellList);
		t2=System.currentTimeMs();
		
		System.out.println("Shell Sort");
		System.out.println("Time taken: "+(double)(t2-t1)+" milliseconds");
		System.out.println();
	}
}