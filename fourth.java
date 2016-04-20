import java.io.*;

class Fourth
{
	static Scanner cin=
	 new Scanner(System.in);
	 
	 public static void main(String [] args)
	 {
		 //get list size 
		 System.out.print("How many? ");
		 int n;
		 n=cin.nextInt();
		 
		 //build array
		 int [] A; //makes the reference
		 A=new int[n]; //create array
		 
		 //int [] A=new int[n];
		 
		 //fill the array
		 System.out.println("Enter your list");
		 for(int i=0; i<n; i++)
		 {
			 A[i]=cin.nextInt();
		 }
	 }
}