//imports
import java.util.Scanner;
/**********************************************************************
Filename: Assign3.java
Version: 1.0
Author:	Martin Choy
Student No:	040835431
Course Name/Number:	CST8130 Data Structures 
Lab Sect:	303
Assignment #: 3
Assignment name: Assignment #3- Dictionary
Due Date:  Jan 2nd 2018 , 11:59PM midnight
Submission Date: Jan 2nd 2018, 6:00PM
Professor: ANU THOMAS
Purpose of Class: This is the main for the whole program. This where
				  the simple menu is displayed where options are made
				  for the tree of words for the dictionary.
				  
				  TL;DR: Runs the basic UI for the User
*********************************************************************/


/*************************************************************************
Function Name: public static void main
Purpose: Main menu with simple error trapping. Just directs options to
		 secondary class(dictionary) where all the work is done.
Version: 1.0
Author: Martin Choy
*************************************************************************/
public class Assign3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Dictionary dic = new Dictionary();
		boolean done = false;
		while (!done) {
			System.out.println("Enter(num for selection):   1 to clear dictionary"+
			"\n\t\t\t    2 to add text from keyboard,"+
			"\n\t\t\t    3 to add text from a file,"+
			"\n\t\t\t    (C:/Users/Marty/Oliver.txt)"+
			"\n\t\t\t    4 to search for a word count,"+
			"\n\t\t\t    5 to display number of nodes,"+
			"\n\t\t\t    6 to exit");
			String option = null;
			while (!sc.hasNextLine()) {
				sc.next();
			}
			option = sc.nextLine().toLowerCase();
			if (option.equals("1")) {
				dic.dictionClr();
			} else if (option.equals("2")) {
				dic.textAdd();
			} else if (option.equals("3")) {
				dic.readFile();
			} else if (option.equals("4")) {
				dic.searching();
			} else if (option.equals("5")) {
				dic.nodeDisplay();
			} else if (option.equals("6")) {
				System.out.println("Exiting program. Goodbye.");
				done = true;
			} else {
				System.out.println("Invalid option, please try again.");
			}
			System.out.println();
		}// end of while
	}// end of main
}// end of class
