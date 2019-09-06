/**********************************************************************
Filename: OurTime.java
Version: 1.1
Author:	Martin Choy
Student No:	040835431
Course Name/Number:	
Lab Sect:	303
Assignment #: 1
Assignment name: Assignment #1- Events Planner – Using ArrayList
Due Date: 11:59pm, Monday 27 November 2017
Submission Date: November 27, 2017 9:30PM
Professor: ANU THOMAS
Purpose of Assignment: Create a program which can handle events within a planner
using ArrayList
Purpose of Class: This class models a time;Contains everything related to the time
*********************************************************************/
/**   This class models a time.
 *	  Author:  Linda Crane, edited by Anu Thomas
 *	  Data fields:  hour: int - values of 0-23 for 24 hour clock 
 *                  minute: int - values 0-59 
 *    Methods:  default constructor
 *              initial constructors
 *				getHour: int - return hour value
 *              getMinute: int - returns minute value
 *				setHour (int) - sets hour to parameter value
 *				setMinute (int) - sets minute to parameter value
 *				isEqual (Time): boolean - returns whether current time object has same time as parameter
 *          **  isGreater (OurTime):boolean - compares two OurTime objects and returns true if current object (this) is 
 *                                            greater than the parameter object; else returns false
 *				toString:String - displays values of time to String
 *				readTime(Scanner, char) - prompts user (if  char is 'k') 
 *                                       to enter values for data fields from Scanner parameter
 */
import java.util.*;

public class OurTime {
	private int hour;
	private int minute;
	
	public OurTime() {
	}
	public OurTime (int hour, int minute){
		this.setHour(hour);
		this.setMinute(minute);
	}
	public OurTime(OurTime time){
		this.hour = time.hour;
		this.minute = time.minute;
	}
	
	// get methods
	public int getHour() { return hour; }
	public int getMinute() { return minute; }
	
	// set methods
	/*************************************************************************
	Function Name: setHour()
	Purpose: sets hour to parameter value
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public void setHour (int hour){
		if (hour < 0 || hour > 23)
			this.hour = 0;
		else this.hour = hour;
	}
	/*************************************************************************
	Function Name: setMinute()
	Purpose: sets minute to parameter value
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public void setMinute (int minute){
		if (minute < 0 || minute > 59)
			this.minute = 0;
		else this.minute = minute;
	}
	
	/*************************************************************************
	Function Name: toString()
	Purpose: displays values of time to String
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public String toString () { return new String ("" + hour + ":" + minute); }
	
	/*************************************************************************
	Function Name: readTime()
	Purpose:  prompts user (if  char is 'k') to enter values for data fields 
			  from Scanner parameter
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean readTime(Scanner in, char prompt) {
		hour = -1;
		minute = -1;
		do {
			if (prompt == 'k')
				System.out.print ("\nEnter hour (0-23): ");
		    if (in.hasNextInt())
		    	this.hour = in.nextInt();
		    else {
		    	System.out.println ("Invalid hour input");
		    	in.next();
				if (prompt != 'k')
					return false;
		    }
		} while (this.hour< 0 || this.hour > 23);
		
		
		do {
			if (prompt == 'k')
				System.out.print ("\nEnter minute (0-59): ");
		    if (in.hasNextInt())
		    	this.minute = in.nextInt();
		    else {
		    	System.out.println ("Invalid minute input");
		    	in.next();
				if (prompt != 'k')
					return false;
		    }
		} while (this.minute< 0 || this.minute > 59);
		return true;
	}
	
	/*************************************************************************
	Function Name: isEqual()
	Purpose: returns whether current time object has same time as parameter
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean isEqual (OurTime time){
		if (this.hour == time.hour && this.minute == time.minute) return true;
		else return false;
	}

	/*************************************************************************
	Function Name: isGreater()
	Purpose: compares two OurTime objects and returns true if current object 
			(this) is greater than the parameter object; else returns false
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean isGreater(int timeToFind) {
		if (timeToFind > hour) {
			if (timeToFind > minute)
			return true;
		}
		return false;
	}

	/*************************************************************************
	Function Name: isLess()
	Purpose: compares two OurTime objects  and returns true if current object 
	is less than the parameter object; else returns false
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean isLess(int timeToFind) {
		if (timeToFind < hour) {
			if (timeToFind < minute)
			return true;
		}
		return false;
	}

}// end of OurTime.java
