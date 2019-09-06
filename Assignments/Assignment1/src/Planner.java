/**********************************************************************
Filename: Planner.java
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
Purpose of Class: This class models an planner that will keep track of events in an array
*********************************************************************/
import java.util.ArrayList;
import java.util.Scanner;
public class Planner {
	final private int MAXEVENTS = 1000;
	final private int MEETING = 1;
	final private int SCHOOL = 2;
	final private int WORK = 3;
	final private int GYM = 4;
	final private int SOCIAL = 5;

	ArrayList<Event> activities = new ArrayList();
	private int numEvents = 0;
	public Planner() {
	}
	/*************************************************************************
	Function Name: inputEvent()
	Purpose: adds an Event to the activities array if there is room
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean inputEvent(Scanner in, char prompt) {
		Event temp = new Meeting();
		Event temps;
		if (numEvents >= MAXEVENTS) {
			System.out.println("Invalid...planner is full");
			return false;
		} else {
			int eventType = 0; //checks valid eventType
			while (eventType < MEETING || eventType > SOCIAL) {
				if (prompt == 'k') {
					System.out.print("Enter the event type"
					+"\n1 ... Meeting Event"
					+"\n2 ... School Event "
					+"\n3 ... Work Event "
					+"\n4 ... Gym Event "
					+"\n5 ... Social Event\n\n");
				}
				if (in.hasNextInt())
					eventType = in.nextInt();
				else {
					System.out.println("Invalid event type....reenter");
					in.next();
					if (prompt != 'k') {
						System.out.println("Invalid type data...not entering event in array");
						return false;
					}
				}
			}
			switch (eventType) {// allocate correct object type to next array entry
			case MEETING:
				temps = new Meeting();
				break;
			case SCHOOL:
				temps = new School();
				break;
			case WORK:
				temps = new Work();
				break;
			case GYM:
				temps = new Social();
				break;
			case SOCIAL:
				temps = new Social();
				break;	
			default:
				temps = new Event();
			}
			if (temp.inputEvent(in, prompt))// add data to the object
				return false;
			// check if there is already an activity at that date and time
			boolean found = false;
			for (int i = 0; i < numEvents; i++) {
				if (activities.get(i).isEqual(temp)) {
					found = true;
					i = numEvents;
				}
			}
			if (found == true) {
				System.out.println("You already have an activity for that date and time...cannot be entered");
				activities.get(numEvents).isEqual(null);
			} else
				numEvents++; 				
		} // end else
		return true;
	}
	/*************************************************************************
	Function Name: toString()
	Purpose: Returns the string representation of the object
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public String toString() {
		String out = new String();
		for (int i = 0; i < numEvents; i++) {
			out += activities.get(i).toString() + "\n";
		}
		return out;
	}
	/*************************************************************************
	Function Name: displayOneDay()
	Purpose: goes through array and displays all events for the parameter date
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public void displayOneDay(OurDate displayDate) {
		System.out.println("Your activities for " + displayDate + " are: ");
		for (int i = 0; i < numEvents; i++)
			if (activities.get(i).getDate().isEqual(displayDate))
				System.out.println(activities.get(i));
	}

	/*************************************************************************
	Function Name: displaySevenDays()
	Purpose: displays events for seven days starting at parameter date
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public void displaySevenDays(OurDate displayDate) {
		System.out.println("Your activities for the week starting " + displayDate + " are: ");
		OurDate currentDate = displayDate;
		for (int j = 0; j < 7; j++) {
			displayOneDay(currentDate);
			currentDate.addOne();
			System.out.println();
		}
	}
	/*************************************************************************
	Function Name: displayAllDays()
	Purpose: displays everything
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public void displayAllDays(OurDate displayDate){
		System.out.println("Your activities for Whole week are: ");
		OurDate currentDate = displayDate;
		for (int j = 0; j < 200; j++) {
			displayOneDay(currentDate);
			currentDate.addOne();
			System.out.println();
		}
	}
	/*************************************************************************
	Function Name: deleteEvent()
	Purpose: Deleting events from arraylist
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public void deleteEvent(Scanner in) {
		OurDate date = new OurDate();
		OurTime time = new OurTime();
		boolean isOk = false;
		System.out.println("Enter date and time of event to delete:");// read in which date/time event to delete
		do {
			isOk = date.readDate(in, 'k');
		} while (!isOk);
		isOk = false;
		do {
			isOk = time.readTime(in, 'k');
		} while (!isOk);
		boolean found = false;
		int i = 1;

		for (i = 0; i < numEvents; i++) {
			if (activities.get(i).getDate().isEqual(date) && activities.get(i).getTime().isEqual(time)) {
				found = true;
				break;
			}
		}
		if (found) {
			// Event to delete has been found 
			activities.get(i).equals(numEvents - 1);
			numEvents--;
			System.out.println("Event deleted");
		} else
			System.out.println("There is no activity for that date and time...cannot be deleted");
	}
	/*************************************************************************
	Function Name: binSearch()
	Purpose: searches arraylist using binary search algorithm returning arraylist index
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public int binSearch(int access) {
		int low = 0;
		int high = activities.size() - 1;

		while (low <= high) {
			int middle = (low + high) / 2;
			if (activities.get(middle).isEqual(access)) {
				return middle;
			}
			if (activities.get(middle).isGreater(access)) {
				high = middle - 1;
			}
			if (activities.get(middle).isLess(access)) {
				low = middle + 1;
			}
		}
		return -1;
	}
}// end of Planner.java