import java.io.*;
import java.util.*;

/** simulation of la food program */

public class Simulate
{
	public Queue waitList = new QueueLL();
	public Queue checkedIn = new QueueLL();
	public int[] Tables = new int[3];
	public int checkedInParty=0;
	public int waitTime=0;
	
	public void start()
		throws IOException
		{
			System.out.println("*** Welcome to La Food Restaurant ***");
			
			fileRead();
			
			int currentTime=0;
			int tableIndex=0;
			
			/** @while simulation runs until the time hits 20 */
			while(currentTime<20)
			{
				currentTime++;
				
				if(!waitList.isEmpty() && currentTime==((Customer)waitList.getFront()).getArrivalTime())
				{
					System.out.println("Please wait at the bar and enjoy some drinks.");
					System.out.println(" Party"+((Customer)waitList.getFront()).toString()+".");
					checkedIn.enqueue(new Customer(((Customer)waitList.getFront())));
					
					waitList.dequeue();
				}
				else if(currentTime==Tables[tableIndex])
				{
					System.out.println("Table for"+((Customer)checkedIn.getFront()).getName()+"!");
					averageWaitTime(((Customer)checkedIn.getFront()).groupNumber, ((Customer)checkedIn.getFront()).getArrivalTime(), currentTime);
					checkedInParty += ((Customer)checkedIn.getFront()).groupNumber;
					
					checkedIn.dequeue();
					tableIndex++;
				}
			}
			
			System.out.println("Simulation is now complete!");
			
			/** @param prints average waiting time for parties */
			double average = ((double)waitTime / (double)checkedInParty);
			System.out.println("The average waiting time was: "+String.format("%.2f", average)+".");
			
			/** @param prints out whether a party didn't get seated */
			if(!checkedIn.isEmpty())
			{
				System.out.println("The following parties never got a seat: ");
				
				while(!checkedIn.isEmpty())
				{
					System.out.println((" Party"+(Customer)checkedIn.getFront()).toString());
					checkedIn.dequeue();
				}
			}
		}
		
		/** @param reads text file "lafood.txt" */
		public void fileRead()
			throws IOException
			{
				Scanner fileInput= new Scanner(new FileReader("lafood.txt"));
				int index= 0;
				boolean w= false;
				String action;
				
				while(!w)
				{
					action= fileInput.next();
					if(action.equals("A"))
					{
						waitList.enqueue(new Customer(fileInput.nextInt(), fileInput.nextInt(), fileInput.nextLine()));
					}
					else if(action.equals("T"))
					{
						Tables[index]= fileInput.nextInt();
						index++;
					}
					else if(action.equals("Q"))
					{
						w=true;
						return;
					}
					else
					{
						System.out.println("...Unknown..."+action);
					}
				}
			}
			
			/** @param calculates avg waiting time */
			public void averageWaitTime(int partySize, int arrivalTime, int seatTime)
			{
				double average=0;
				waitTime += partySize*(seatTime - arrivalTime);
			}
}