/**********************************************************************
Filename: EmailList.java
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
Purpose of Class: This class is used for add, delete , display and returning
				 the size of entry in the list. It will also show entries in the 
				 directory and compare them with EmailList.
				 This class contains two fields a string name and a Linklist.
*********************************************************************/
//Java imports
import java.util.List;
import java.util.LinkedList;

public class EmailList {

	private String name = null;
	private List<EmailAddress> addresses = null;
	/*************************************************************************
	Purpose: Constructor with arguments or a Parameterized constructor.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public EmailList(String name) {
		this.name = name;
		this.addresses = new LinkedList<EmailAddress>();
	}
	/*************************************************************************
	Function Name:  addEntry(EmailAddress emailAddress)
	Purpose: This is used to add an entry to the list. 
			 Parameter EmailAddress.
	Version: 1.0
	Author:  Martin Choy
	*************************************************************************/
	public void addEntry(EmailAddress emailAddress) {
		addresses.add(emailAddress);
	}
	/*************************************************************************
	Function Name: removeEntry(int index)
	Purpose: Method used to remove a entry at a specified position within the list
	Version: 1.0
	Author:  Martin Choy
	*************************************************************************/
	public void removeEntry(int index) {
		addresses.remove(index);
	}
	/*************************************************************************
	Function Name: display()
	Purpose: This is used to display all the entries within the list
	Version: 1.0
	Author:  Martin Choy
	*************************************************************************/
	public void display() {
		System.out.print(name + ":[");

		for (int i = 0; i < addresses.size(); i++) {
			if (i > 0)
				System.out.println(",");
			System.out.print(addresses.get(i));
		}
		System.out.println("]");
	}
	/*************************************************************************
	Function Name:  appear()
	Purpose: This is used to reveal all the entries in the directory for the 
			 selected. 
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public void appear() {
		System.out.println(name);
		for (int i = 0; i < addresses.size(); i++) {
			System.out.println(i + " " + addresses.get(i));
		}
	}
	/*************************************************************************
	Function Name: isEqual(String name)
	Purpose: This is used to compare name with EmailList.
			 Parameter String name and returns a true or false.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public boolean isEqual(String name) {
		if (this.name.equals(name)) {
			return true;
		} else {
			return false;
		}
	}
	/*************************************************************************
	Function Name: size()
	Purpose: This is used for returning the number of entries in the list.
			 Returns number of entries. 
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public int size() {
		return addresses.size();
	}
}
