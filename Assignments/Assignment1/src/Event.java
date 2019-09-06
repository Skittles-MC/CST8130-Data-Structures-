/**********************************************************************
Filename: Event.Java
Version: 1.1
Author:	Martin Choy
Student No:	040835431
Course Name/Number:	
Lab Sect:	303
Assignment #: 1
Assignment name: Assignment #1- Events Planner – Using ArrayList
Due Date: 11:59pm, Monday 27 November 2017
Submission Date: November 27, 2017 8:40PM
Professor: ANU THOMAS
Purpose of Assignment: Create a program which can handle events within a planner
using ArrayList
Purpose of Class: Events holds data fields of:
date:  OurDate - the day/month/year of the event
time:  OurTime - the hour/minute that event starts at
description: String - a description of event
*********************************************************************/
import java.util.*;
public class Event {
	private OurDate date = new OurDate();
	private OurTime time = new OurTime();
	private String description = new String();
	public Event() {
	}
	public Event (OurDate date, OurTime time, String description){
		this.date = new OurDate(date);
		this.time = new OurTime (time);
		this.description = new String (description);
	}
	public Event (int day, int month, int year, int hour, int minute, String description){
		this.date = new OurDate (day, month, year);
		this.time = new OurTime (hour, minute);
		this.description = new String (description);
	}
	// get methods
	public OurDate getDate() { return date;}
	public OurTime getTime() { return time; }
	/*************************************************************************
	Function Name: toString()
	Purpose: Returns the string representation of the object
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	// accessor methods and mutators
	public String toString() {
		return new String("     " + date + " " + time + " " + description);
	}
	/*************************************************************************
	Function Name: inputEvent()
	Purpose: Checks validness and allows the user to enter event description
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean inputEvent(Scanner in, char prompt) {	
		if (!date.readDate(in, prompt)) {
			return false;
		}
		if (!time.readTime(in, prompt)) {
			return false;
		}
		if (prompt == 'k')
			System.out.print ("Enter event description: ");
		this.description = in.next();
		return true;
	}	
	/*************************************************************************
	Function Name: isEqual()
	Purpose: compares date and time in two objects and returns true/false if they are equal
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean isEqual (Event rhs) {
		return (this.date.isEqual(rhs.date) && this.time.isEqual(rhs.time));
	}
	/*************************************************************************
	Function Name: IsGreater()
	Purpose: Return false
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean isGreater(int access) {
		return false;
	}
	/*************************************************************************
	Function Name: isLess()
	Purpose: Return false
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean isLess(int access) {
		return false;
	}
	/*************************************************************************
	Function Name: isEqual()
	Purpose: Return false
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean isEqual(int access) {

		return false;
	}
}// end of Event.java