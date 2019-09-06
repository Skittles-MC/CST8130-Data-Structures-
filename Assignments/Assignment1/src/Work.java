/**********************************************************************
Filename: Work.java
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
Purpose of Class: This class represents a work event;it's superclass is Event.
*********************************************************************/
import java.util.*;
public class Work extends Event {
	private int shiftLength;

	public Work() {
	}
	public Work(OurDate date, OurTime time, String description, int shiftLength) {
		super(date, time, description);
		this.shiftLength = shiftLength;
	}

	public Work(int day, int month, int year, int hour, int minute, String description, int shiftLength) {
		super(day, month, year, hour, minute, description);
		this.shiftLength = shiftLength;
	}
	/*************************************************************************
	Function Name: toString()
	Purpose: displays assignment event to a String
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public String toString() {
		return super.toString() + " for " + shiftLength;
	}
	/*************************************************************************
	Function Name: inputEvent()
	Purpose: prompts char parameter starts with 'k'
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean inputEvent(Scanner in, char prompt) {
		if (!super.inputEvent(in, prompt))
			return false;
		do {
			if (prompt == 'k')
				System.out.print("Enter shiftLength - greater than 0 :");
			if (in.hasNextInt())
				shiftLength = in.nextInt();
			else {
				System.out.println("Invalid value for shift length");
				in.next();
				if (prompt != 'k')
					return false;
			}
		} while (shiftLength <= 0);
		return true;
	}
}// end of Work.java
