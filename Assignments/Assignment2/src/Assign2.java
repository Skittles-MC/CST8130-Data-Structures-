/**********************************************************************
Filename: Assign2.java
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
Purpose of Class: This is the main for the whole program. Basically a driver
			      class.
*********************************************************************/
//All java imports
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

public class Assign2 {
	private Scanner sc = new Scanner(System.in);
	private Directory directory = new Directory();
	
	public static void main(String[] args) {
		Assign2 assign2 = new Assign2();
		assign2.mainMenu();
	}
	/*************************************************************************
	Function Name: mainMenu()
	Purpose: This is where the menu is displayed, and providing the user menu
			 selections down below which loops until they choose to exit.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public void mainMenu() {
		boolean done = false;
		while (!done) {
			System.out.println("Enter c to create a new list");
			System.out.println("      p to display all the email lists");
			System.out.println("      a to add an entry to a list");
			System.out.println("      d to delete an entry from a list");
			System.out.println("      l to display a list");
			System.out.println("      f to load lists from file");
			System.out.print("      q to quit: ");
			String option = null;
			while (!sc.hasNextLine()) {
				sc.next();
			}
			option = sc.nextLine().toLowerCase();
			if (option.equals("c")) {
				generateList();
			} else if (option.equals("p")) {
				allListDisplays();
			} else if (option.equals("a")) {
				entryAddIntoList();
			} else if (option.equals("d")) {
				removeEntryFromTheList();
			} else if (option.equals("l")) {
				singleListDisplay();
			} else if (option.equals("f")) {
				readFile();
			} else if (option.equals("q")) {
				System.out.println("Quit");
				done = true;
			} else {
				System.out.println("Invalid option, please try again.");
			}
			System.out.println();
		}
	}
	/*************************************************************************
	Function Name: generateList()
	Purpose: This is used to prompt the user to end data for a brand new list
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	private void generateList() {
		String name = nameEntry("Enter the name of the list: ");
		EmailList emailList = emailListFinder(name);
		if (emailList == null) {
			emailList = new EmailList(name);
			enterEmailAddress(emailList);
			directory.emailListAdd(emailList);
		} else {
			System.out.println("The EmailList with the name already exist.");
		}
	}
	/*************************************************************************
	Function Name: allListDisplays()
	Purpose: This is used to display all EmailLists in the current directory.
			 Quite straight forward approach.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	private void allListDisplays() {
		directory.display();
	}
	
	/*************************************************************************
	Function Name: singleListDisplay()
	Purpose: This is used to prompt the user to enter a valid name of a EmailList
			 which displays the list if valid...If not valid a message will prompt
			 saying otherwise. 
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	private void singleListDisplay() {
		String name = nameEntry("Enter name of list to display: ");
		EmailList emailList = emailListFinder(name);
		if (emailList != null) {
			emailList.display();
		} else {
			System.out.println("The EmailList does not exist.");
		}
	}
	/*************************************************************************
	Function Name: entryAddIntoList()
	Purpose: This is used for prompting the user to enter the name of the EmailList
			 for adding into the list. Checks if valid/exists or not.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	private void entryAddIntoList() {
		String name = nameEntry("Enter name of list to add to: ");
		EmailList emailList = emailListFinder(name);

		if (emailList != null) {
			EmailAddress emailAddress = new EmailAddress();
			emailAddress.readAdress(sc, "k");
			emailList.addEntry(emailAddress);
			sc.nextLine();
		} else {
			System.out.println("The EmailList does not exist.");
		}
	}
	/*************************************************************************
	Function Name: removeEntryFromTheList()
	Purpose: This will prompt the user to enter in the name of the EmailList 
			 which will delete/remove it. Also checks if it is valid or not.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	private void removeEntryFromTheList() {
		String name = nameEntry("Enter name of list to delete from: ");
		EmailList emailList = emailListFinder(name);
		if (emailList != null) {
			int count = emailList.size();
			if (count > 0) {
				emailList.appear();
				int index = -1;
				while (true) {
					System.out.print("Enter entry number to delete: ");
					try {
						index = sc.nextInt();
						sc.nextLine();
						break;
					} catch (InputMismatchException ex) {
						System.err.println("Please enter an integer");
						sc.nextLine();
					}
				}
				if (index >= 0 && index < count) {
					emailList.removeEntry(index);
				} else {
					System.out.println("The entry number is out of range.");
				}
			} else {
				System.out.println("The EmailList is empty.");
			}
		} else {
			System.out.println("The EmailList does not exist.");
		}
	}
	/*************************************************************************
	Function Name: readFile()
	Purpose: Reads in EmailLists from a file.
	Version: 1.0
	Author: Martin Choy
	Additional Notes: Needs absolute directory enter this way.
	*************************************************************************/
	private void readFile() {
		String filename = null;
		System.out.print("Enter name of file to process(like this C:/Users/Marty/emailListsSample.txt): ");
		while (true) {
			while (!sc.hasNextLine()) {
				sc.next();
			}
			filename = sc.nextLine().trim();

			if (!filename.equals("")) {
				break;
			}
		}
		Scanner scanner = openFile(filename);
		if (scanner != null) {
			// Read the line count.
			int totalLines = 0;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();

				if (!line.equals("")) {
					try {
						totalLines = Integer.parseInt(line);

						if (totalLines <= 0) {
							System.out.println("The total lines must be a positive integer: " + line);
							return;
						}
						break;
					} catch (NumberFormatException ex) {
						System.out.println("Cannot find the total lines: " + line);
						return;
					}
				}
			}
			int lineCount = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				if (!line.equals("")) {
					lineCount++;
					Scanner s = new Scanner(line).useDelimiter(" ");
					String name = s.next();
					int numberOfEmailAddresses = s.nextInt();
					EmailList emailList = new EmailList(name);
					for (int i = 0; i < numberOfEmailAddresses; i++) {
						emailList.addEntry(new EmailAddress(s.next()));
					}
					directory.emailListAdd(emailList);

					if (lineCount >= totalLines) {
						break;
					}
				}
			}

			scanner.close();
		} else {
			System.out.println(filename + " not found");
		}
	}
	/*************************************************************************
	Function Name: nameEntry(String prompt)
	Purpose: This prompts the user to enter a name which represents the EmailList
			 and returns the name. Returns String.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	private String nameEntry(String prompt) {
		String name = null;
		boolean done = false;
		while (!done) {
			System.out.print(prompt);
			while (!sc.hasNextLine()) {
				sc.next();
			}
			name = sc.nextLine().trim();
			if (!name.equals("")) {
				done = true;
			}
		}
		return name;
	}
	/*************************************************************************
	Function Name: enterEmailAddress(EmailList emailList)
	Purpose: Will prompt the user to enter email addresses forever unless
			 user says no or N. Will check if its valid or not.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	private void enterEmailAddress(EmailList emailList) {
		boolean done = false;
		EmailAddress emailAddress = null;

		while (!done) {
			emailAddress = new EmailAddress();
			emailAddress.readAdress(sc, "k");
			emailList.addEntry(emailAddress);
			sc.nextLine();
			System.out.print("Another? y/n: ");

			while (!sc.hasNextLine()) {
				sc.next();
			}
			String option = sc.nextLine().toLowerCase();

			if (option.equals("y")) {
				continue;
			} else if (option.equals("n")) {
				done = true;
			} else {
				System.out.println("Invalid option, please try again.");
			}
		}
	}
	/*************************************************************************
	Function Name: emailListFinder(String name)
	Purpose: This is used to find a specified/specific EmailList for a given name
			 Returns EmailList
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	private EmailList emailListFinder(String name) {
		return directory.emailListLocator(name);
	}
	private Scanner openFile(String filename) {
		File file = new File(filename);

		if (file.exists()) {
			try {
				Scanner scanner = new Scanner(file);

				return scanner;
			} catch (FileNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}
	}
}
