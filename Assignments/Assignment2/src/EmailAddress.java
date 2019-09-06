/**********************************************************************
Filename: EmailAddress.java
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
Purpose of Class: Listed by Prof. And provided by prof
*********************************************************************/
import java.util.Scanner;
/***********************************************************************************
Class:  EmailAddress
Purpose:  This class will model the data and actions needed for an email address data type
Author:   Anu Thomas
Course:   CST8130 - Data Structures
Data members:   emailAddress: String - hold the value of a valid email address
Methods: EmailAddress() - default constructor - set empty string field
		 EmailAddress(String) -  sets object to String parameter emailAddress if valid 
         toString(): String - returns the data of the emailAddress field
         readAddress(Scanner)- reads in valid address from Scanner if prompt is 'k' otherwise reads from file      	          
*************************************************************************************/
//Did not modify since was in the original file provided by Prof; Already written class is not to be modified. 
import java.util.Scanner;
public class EmailAddress {
	private String emailAddress;
	public EmailAddress(){
		emailAddress = new String();
	}
	public EmailAddress (String email){
		if(email.contains("@") && email.contains(".") && email.length()>7)
			emailAddress = email;
	}
	
	public String toString(){
		return emailAddress;
	}
	public void readAdress (Scanner in, String prompt){
		if(prompt.charAt(0) == 'k')
			System.out.println("Enter valid email address: ");
		emailAddress = in.next();
		
		while(!emailAddress.contains("@") || !emailAddress.contains(".") || emailAddress.length() < 7){
			System.out.println("Enter valid email address.... it should contain @ and . and should be atleast 7 characters long");
			emailAddress = in.next();
		}
	}
}
