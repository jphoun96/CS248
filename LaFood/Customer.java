import java.util.*;

/**
program is used with la food program
*/

public class Customer
{
	int arrivalTime = 0;
	int groupNumber = 0;
	String name = "";


	/** constructor */
	public Customer()
	{
		arrivalTime = 0;
		groupNumber = 0;
		name = "";
	}

	/**
	@param at= time of arrival
	g= # of people in group 
	n= name of customer
	*/
	public Customer(int at, int g, String n)
	{
		arrivalTime= at;
		groupNumber= g;
		name= n;
	}

	public Customer(Customer c)
	{
		arrivalTime= c.arrivalTime;
		groupNumber= c.groupNumber;
		name= c.name;
	}

	/** scanner to text file */
	public Customer(Scanner s)
	{
		arrivalTime= s.nextInt();
		groupNumber= s.nextInt();
		name= s.next();
	}

	/** @return the time of arrival of party */
	public int getArrivalTime()
	{
		return arrivalTime;
	}

	/** @return # of people in party */
	public int getGroupNumber()
	{
		return groupNumber;
	}

	/** @return name of customer */
	public String getName()
	{
		return name;
	}

	public String toString()
	{
		return(name +" of "+groupNumber+ " people.");
	}

}