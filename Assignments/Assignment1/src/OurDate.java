/**********************************************************************
Filename: OurDate
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
Purpose of Class: This class models a date; Contains everything related to the date
*********************************************************************/
/**   This class models a date.
 *	  Author:  Linda Crane, updated by Anu Thomas
 *   
 *	  Data fields:  day: int - values of 1-31 
 *                  month: int - values 1-12 for January - December
 *                  year: int - value for year
 *    Methods:  default constructor
 *              initial constructors
 *				getDay: int - return day value
 *              getMonth: int - returns month value
 *              getYear: int - returns year value
 *				setDay (int) - sets day to parameter value
 *				setMonth (int) - sets month to parameter value
 *				setYear (int) - sets year to parameter value
 *			**	isEqual (OurDate): boolean - returns whether current date object has same date as parameter  ** you have to define this method
 *          **  isGreater (OurDate):boolean - compares two OurDate objects and returns true if current object (this) is 
 *                                            greater than the parameter object; else returns false  ** you have to define this method
 *				toString:String - displays values of date to String
 *				readDate (Scanner, char) - prompts user to enter values if the value is k, otherwise read from file                          
 *				addOne - adds one day to the current date object
 */

import java.util.*;
public class OurDate {
	private int day = 1;
	private int month = 1;
	private int year = 2017;
	
	public OurDate() {
	}
	public OurDate (int day, int month, int year){
		setMonth (month);
		setYear (year);
		setDay(day);
	}
	
	public OurDate (OurDate date){
		this.day = date.day;
		this.month = date.month;
		this.year = date.year;
	}
	
	// get methods
	public int getDay () { return day; }
	public int getMonth() { return month;}
	public int getYear() { return year; }
	
	/*************************************************************************
	Function Name: setDay()
	Purpose: sets day to parameter value
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public void setDay (int day){
		if (day <= 0 || day > 31) 
			this.day = 1;
		else if (this.month == 2 && day > 29) 
			this.day = 1;
		else if (this.day > 30 && (this.month == 9 ||this.month == 4 ||this.month == 6 ||this.month == 11) )
			this.day = 1;
		else this.day = day;
	}
	/*************************************************************************
	Function Name: setMonth()
	Purpose: sets month to parameter value
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public void setMonth (int month){
		if (month < 0 || month > 12 )
			this.month = 1;
		else this.month = month;
	}
	/*************************************************************************
	Function Name: setYear()
	Purpose: sets year to parameter value
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public void setYear (int year){
		if (year < 0)
			this.year = 2010;
		else this.year = year;
	}
	
	/*************************************************************************
	Function Name: isEqual()
	Purpose: returns whether current date object has same date as parameter
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean isEqual (OurDate date){
		if (this.year == date.year && this.month == date.month && this.day == date.day)
			return true;
		else return false;
	}
	/*************************************************************************
	Function Name: isGreater()
	Purpose: compares two OurDate objects and returns true if current object 
			 (this) is greater than the parameter object; else returns false
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean isGreater(int dayToFind) {
		if (dayToFind > year) {
			if (dayToFind > month)
				if (dayToFind > day)
			return true;
		}
		return false;
	}
	/*************************************************************************
	Function Name: isLess
	Purpose: compares two OurDate objects and returns true if current object 
			 (this) is less than the parameter object; else returns false
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public boolean isLess(int dayToFind) {
		if (dayToFind < year) {
			if (dayToFind < month)
				if (dayToFind < day)
			return true;
		}
		return false;
	}

	/*************************************************************************
	Function Name: toString()
	Purpose: displays values of date to String
	Version: 1.1
	Author: Martin Choy
	*************************************************************************/
	public String toString() {   return new String ("" + year + "/" + month + "/" + day);
	}
	
	public boolean readDate(Scanner in, char prompt) {
		month = 0;
		day = 0; 
		year = 0;
		
		do {
			if (prompt == 'k')
				System.out.print ("Enter day - between 1 and 31: ");
			if (in.hasNextInt())
				this.day = in.nextInt();
			else {
				System.out.println ("Invalid day input");
				in.next();
				if (prompt != 'k')
					return false;
			}
		} while (this.day <= 0 || this.day > 31 || (this.month == 2 && this.day > 29) || (this.day > 30 && (this.month == 9 ||this.month == 4 ||this.month == 6 ||this.month == 11) ) );
		
		
		do {
			if (prompt == 'k')	
				System.out.print ("\nEnter month - between 1 and 12: ");
			if (in.hasNextInt())
				this.month = in.nextInt();
			else {
				System.out.println ("Invalid month input");
				in.next();
				if (prompt != 'k')
					return false;
			}
		} while (this.month <= 0 || this.month > 12);
		
	
		
		do {
			if (prompt == 'k')
				System.out.print ("Enter year: ");
			if (in.hasNextInt())
				this.year = in.nextInt();
			else {
				
				System.out.println ("Invalid year input  " + this.year);
				in.next();
				if (prompt != 'k')
					return false;
			}
		} while (this.year <= 0);
		
		return true;		
	}
	
	public void addOne (){
		this.day++;
		if (this.day > 31 || (this.month == 2 && this.day > 29) || (this.day > 30 && (this.month == 9 ||this.month == 4 ||this.month == 6 ||this.month == 11) ) ){ 
			this.day = 1;
			this.month ++;
			if (this.month > 12) {
				this.month = 1;
				this.year++;
			}
		}
	}

}// end of OurDate.java
