//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
/**********************************************************************
Filename: Dictionary.java
Version: 1.0
Author:	Martin Choy
Student No:	040835431
Course Name/Number:	CST8130 Data Structures 
Lab Sect:	303
Assignment #: 3
Assignment name: Assignment #3- Dictionary
Due Date: Jan 2nd 2018 , 11:59PM midnight
Submission Date: Jan 2nd 2018, 6:00PM
Professor: ANU THOMAS
Purpose of Class: Reads from file while adding words into treemap and while counting the appearances. 
				  Opens file with specified name; Allows for adding of word/letter towards tree map from user input.
				  Searches each of the elements in the tree map. And will try to find the user input search result.
		
			TL;DR:This is where the class proceeds to build a tree with 
				  words of the dictionary.
				  
				  With the following methods:
				  dictionClr()
				  nodeDisplay()
				  wordAdd()
				  stringAdd()
				  textAdd()
				  searching()
				  openFile()
				  readFile()
*********************************************************************/
    public class Dictionary {
	private Scanner sc = new Scanner(System.in);
	private TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	/*************************************************************************
	Function Name: dictionClr()
	Purpose: Clears the whole dictionary of anything. Method used to reset the
			 tree to emptiness. Simple clear/reset method
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public void dictionClr() {
		map.clear();
		System.out.println("The dictionary has been reset to empty.");
	}// end of method
	/*************************************************************************
	Function Name:  nodeDisplay()
	Purpose: This method is used to display the number of nodes within the current
			 dictionary/file. Counts the nodes in tree map and returns the current number
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public void nodeDisplay() {
		int size = map.size();
		if (size == 0) {
			System.out.printf("The dictionary is empty\n");
		}// end of if 
		else if (size == 1) {
			System.out.printf("There is only one node\n");
		}// end of else if 
		else {
			System.out.printf("There are %d nodes\n", size);
		}// end of else
	}// end of method
	/*************************************************************************
	Function Name: wordAdd(String text)
	Purpose: This method is used to prompt the user to add words
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	private int wordAdd(String text) {
		String[] words = text.toLowerCase().split(" ");
		int count = 0;
		for (String word : words) {
			word = word.replaceAll("[^A-Za-z]", "");
			if (word.equals(""))
				continue;
			Integer value = map.get(word);
			if (value == null) {
				value = new Integer(1);
			}// end of if
			else {
				value = new Integer (value.intValue() + 1);
			}// end of else
			map.put(word, value);
			count++;
		}// end of for
		return count;
	}// end of method
	/*************************************************************************
	Function Name: stringAdd(String value)
	Purpose: This method used to prompt user to enter a string, and returns it 
		     afterwards.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	private String stringAdd(String value) {
		String sth = null;
		boolean done = false;
		while (!done ){
			System.out.println(value);
			while (!sc.hasNextLine())
				sc.next();
			sth = sc.nextLine().trim();
			if (!sth.equals("")) 
				done = true;
		}// end of while
		return sth;
	}// end of method
	/*************************************************************************
	Function Name: textAdd()
	Purpose: This method used to prompt user to enter some text which adds
			 words into the dictionary from keyboard.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public void textAdd() {
		String text = stringAdd("Enter text you want to add: ");
		int count = wordAdd(text);
		System.out.printf("Number of words added: %d\n", count);
	}// end of method
	/*************************************************************************
	Function Name: searching()
	Purpose: This method used to prompt user to enter a word, and afterwards
	         searchers for the word count. Searches each of the elements in
	         the tree map.
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public void searching() {
		String word = stringAdd("Enter word to search for: ");
		word = word.replaceAll("[^A-Za-z]", "");
		Integer value = map.get(word.replaceAll("[^A-Za-z]", "").toLowerCase());
		if (value == null) {
			System.out.printf("%s not found\n", word);
		}// end of if 
		else if (value == 1) {
			System.out.printf("%s occurs one time\n", word);
		}// end of else if 
		else {
			System.out.printf("%s occurs %d times\n", word, value);
		}// end of else
	}// end of method
	/*************************************************************************
	Function Name: openFile
	Purpose: Used to open a file
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public Scanner openFile (String filename) {
		File file = new File (filename);
		if (file.exists()) {
			try {
				Scanner scan = new Scanner(file);
				return scan;
			} catch (FileNotFoundException e) {
				return null;
			}
		}// end of if
		else {
			return null;
		}// end of else
	}// end of method
	/*************************************************************************
	Function Name: readFile()
	Purpose: Used to read in words from a selected file
	Version: 1.0
	Author: Martin Choy
	*************************************************************************/
	public void readFile() {
		String file = null;
		System.out.print("Enter name of file to process: ");
		while (true) {
			while (!sc.hasNextLine()) {
				sc.next();
			}// end of while
			file = sc.nextLine().trim();
			if (!file.equals("")) {
				break;
			}// end of if
		}// end of while
		Scanner scan = openFile (file);
		if (scan != null) {
			while (scan.hasNextLine()) {
				String line = scan.nextLine().trim();
				if (!line.equals("")) {
					wordAdd(line);
				}// end of if
			}// end of while
			scan.close();
		} else {
			System.out.println(file + " not found");
		}// end of else
	}// end of method
}// end of class