/**********************************************************************
Filename: Directory.java
Version: 1.0
Author:	Martin Choy
Student No:	040835431
Course Name/Number:	CST8130 Data Structures 
Lab Sect:	303
Assignment #: 2
Assignment name: Assignment #2- Email Lists
Due Date: 11:59pm, Monday 18 December 2017
Submission Date: December 18, 2017 10:00PM 
Professor: ANU THOMAS
Purpose of Class: To add, display and search the EmailList within the
directory....This class(Directory.java) holds an ArrayList of EmailList objects
*********************************************************************/
//java imports
import java.util.List;
import java.util.ArrayList;


public class Directory {

	private List<EmailList> list = null;
	/*************************************************************************
	Purpose:Default constructor.
	Version: 1.0
	Author:  Martin Choy
	*************************************************************************/
	public Directory() {
		this.list = new ArrayList<EmailList>();
	}
	/*************************************************************************
	Function Name: emailListAdd(EmailList emailList)
	Purpose: This is used to add a EmailList towards the directory.
			 Parameter emailList
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public void emailListAdd(EmailList emailList) {
		list.add(emailList);
	}
	/*************************************************************************
	Function Name: display()
	Purpose: Used to display all EmailLists in the directory
	Version: 1.0
	Author:  Martin Choy
	*************************************************************************/
	public void display() {
		System.out.println("The email lists are: ");
		for (EmailList emailList: list) {
			emailList.display();
		}
	}
	/*************************************************************************
	Function Name: findEmailList(String name)
	Purpose: This is used to find a emaillist for a given name.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public EmailList emailListLocator(String name) {
		for (EmailList emailList: list) {
			if (emailList.isEqual(name)) {
				return emailList;
			}
		}
		return null;
	}
}
