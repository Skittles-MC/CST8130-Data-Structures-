/**********************************************************************
Filename: Meeting.java
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
Purpose of Class: Represents a meeting event, it's superclass is Event. 
*********************************************************************/
import java.util.*;
public class Meeting extends Event {
    private String location = new String();
    public Meeting() {
    }
    public Meeting  (OurDate date, OurTime time, String description, String location){
		super (date, time, description);
		this.location = new String (location);
	}
	public Meeting (int day, int month, int year, int hour, int minute, String description){
		super (day, month, year, hour, minute, description);
		this.location = new String (location);
	}	
	/*************************************************************************
	Function Name: toString()
	Purpose: displays meeting event to a String
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public String toString() {
		return super.toString() + " at " + location;
	}
	/*************************************************************************
	Function Name: inputEvent()
	Purpose: input promts from Scanner parameter  for all data fields
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean inputEvent(Scanner in, char prompt) {
		if (!super.inputEvent(in, prompt))
				return false;
		if (prompt == 'k')
			System.out.print ("Enter location :");
		location = in.next();
		return true;
	}  
}// end of Meeting.java