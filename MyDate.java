//Date Program
//Programmer: Jonathan Phoun

import java.io.*;
import java.util.*;

public class MyDate implements DateInterface 
{
	int d;
	int m; 
	int y; 
	int dow; 
	
	/** @return day of the month */
	public int getDay()
	{
		return d;
	}
	
	/** @return day of the week */
	public int getDow()
	{
		return dow;
	}
	
	/** @return month of the year */
	public int getMonth()
	{
		return m;
	}
	
	/** @return year */
	public int getYear()
	{
		return y;
	}
	
	
	/** @param d2 (1-31)
		@param m2 (1-12)
		@param y2 (YYYY)
		@param dow2 (0-6)
		*/
	public void set(int d2, int m2, int y2, int dow2)
	{
		d= d2;
		m= m2;
		y= y2;
		dow= dow2;
	}
	
	
	/** moves date one day foward */
	public void tomorrow()
	{
		if (checkMonth()==false)
		{
		if(checkDay()==false)
		{
			d++;
			nextdow();
		}
		else
		{
			d=1;
			m++;
			nextdow();
		}
		}
		else
		{
			if(checkDay()==false)
			{
				d++;
				nextdow();
			}
			else
			{
				d=1;
				m=1;
				y++;
				nextdow();
			}
		}
	}
	
	public boolean checkDay()
	{
		switch(m)
		{
			case 1:
			if(d>=31){return true;}
			else{return false;}
			
			/** february is leap month (28 or 29 days)*/
			case 2:
			if(LeapYear()==false)
			{
				if(d>=28){return true;}
				else {return false;}
			}
			else
			{
				if(d>=29){return true;}
				else{return false;}
			}
			
			case 3:
			if(d>=31){return true;}
			else{return false;}
			
			case 4:
			if(d>=30){return true;}
			else{return false;}
			
			case 5:
			if(d>=31){return true;}
			else{return false;}
			
			case 6:
			if(d>=30){return true;}
			else{return false;}
			
			case 7:
			if(d>=31){return true;}
			else{return false;}
			
			case 8:
			if(d>=31){return true;}
			else{return false;}
			
			case 9:
			if(d>=30){return true;}
			else{return false;}
			
			case 10:
			if(d>=31){return true;}
			else{return false;}
			
			case 11:
			if(d>=30){return true;}
			else{return false;}
			
			case 12:
			if(d>=31){return true;}
			else{return false;}
		}
		return true;
	}
	
	/** @return true if december*/
	public boolean checkMonth()
	{
		if(m>=12){return true;}
		else{return false;}
	}
	
	/** leap year if the year is divisible by 4, but not by 100, 
	or if it is divisible by 100, it must also be divisible by 400 */
	public boolean LeapYear()
	{
		if((y % 4 == 0) && (y % 100 != 0) || (y % 400 == 0)){return true;}
		
		else{return false;}
	}
	
	/** @return true if saturday */
	public boolean checkDOW()
	{
		if(dow>=7){return true;}
		else{return false;}
	}
	
	/** moves day of week forward by 1*/
	public void nextdow()
	{
		if(checkDOW()==false)
		{
			dow++;
		}
		else
		{
			dow=1;
		}
	}
	
	public String toString()
	{
		String dateString="";
		String dowString="";
		String mString="";
		
		switch(dow)
		{
			case 1:
			dowString="Sunday";
			break;
			
			case 2:
			dowString="Monday";
			break;
			
			case 3:
			dowString="Tuesday";
			break;
			
			case 4:
			dowString="Wednesday";
			break;
			
			case 5:
			dowString="Thursday";
			break;
			
			case 6:
			dowString="Friday";
			break;
			
			case 7:
			dowString="Saturday";
			break;
		}
		
		switch(m)
		{
			case 1:
			mString="January";
			break;
			
			case 2:
			mString="February";
			break;
			
			case 3:
			mString="March";
			break;
			
			case 4:
			mString="April";
			break;
			
			case 5:
			mString="May";
			break;
			
			case 6:
			mString="June";
			break;
			
			case 7:
			mString="July";
			break;
			
			case 8:
			mString="August";
			break;
			
			case 9:
			mString="September";
			break;
			
			case 10:
			mString="October";
			break;
			
			case 11:
			mString="November";
			break;
			
			case 12:
			mString="December";
			break;
		}
		
		
		dateString = (dowString+" "+mString+" "+getDay()+" "+getYear()+" ");
		return dateString;
	}

	
	public void today()
	{
		
	}
	
	public void yesterday()
	{
		
	}
	
}

//result of running program
//Friday January 1 3000
