/**********************************************************************
Filename: Assign1.java
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
Purpose of Class: Houses main, main menu UI and openFile functions
*********************************************************************/
//imports
import java.io.File;
import java.io.IOException;
import java.util.*;
/*************************************************************************
Function Name: Main()
Purpose: Menu interface for the user.
Version: 1.1
Author: Martin Choy
*************************************************************************/
public class Assign1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner inFile = null;
		Planner planner = new Planner();
		OurDate displayDate = new OurDate();
		int menuChoice = 1;
		while (menuChoice != 0) {
			// loop to enter valid MenuChoice...
			do {
				System.out.print("\n1 ... Add an event from keyboard   "
								+"\n2 ... Display events of a day  "
				+"\n3 ... Display events of a week   "
				+"\n4 ... Delete an event  "
				+"\n5 ... Add events from a file  "
				+"\n6 ...Display all events"
				+"\n0 ... Quit ");
				if (in.hasNextInt())
					menuChoice = in.nextInt();
				else {
					in.next();
					System.out.println("Invalid menu choice....reenter: ");
					menuChoice = -1;
				}
			} while (menuChoice < 0 || menuChoice > 6);
			if (menuChoice == 1) {
				planner.inputEvent(in, 'k');
			} else if (menuChoice == 2) {
				System.out.println("Enter a date to display: ");
				if (displayDate.readDate(in, 'k'))
					planner.displayOneDay(displayDate);
			} else if (menuChoice == 3) {
				System.out.println("Enter a date to display: ");
				if (displayDate.readDate(in, 'k'))
					planner.displaySevenDays(displayDate);
			} else if (menuChoice == 4) {
				planner.deleteEvent(in);
			} else if (menuChoice == 5) {
				inFile = openFile(in);
				if (inFile != null) {
					while (inFile.hasNext()) {
						if (!planner.inputEvent(inFile, 'n'))
							break;
					}
				}
			}
			else if (menuChoice == 6){
				planner.displayAllDays(displayDate);
			}
		}
	}// end of main
	/*************************************************************************
	Function Name: openFile()
	Purpose: Opens files contents 
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public static Scanner openFile(Scanner in) {
		String fileName = new String();
		Scanner inFile = null;

		System.out.print("\n\nEnter name of file to process: ");
		fileName = in.next();

		File file = new File(fileName);
		try {
			if (file.exists()) {
				inFile = new Scanner(file);
			} else
				System.out.println("File does not exist.....");
			return inFile;
		} catch (IOException e) {
			System.out.println("Could not open file...." + fileName + "exiting");
			return null;
		}
	}// end openFile method
}// end of Assign1.java
