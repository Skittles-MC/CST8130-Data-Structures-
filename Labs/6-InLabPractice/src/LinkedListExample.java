/***********************************
 * Modified version of Lab 5 from Last week
 * Dec 11th 3:42PM
 * Added in the following changes to Lab 5 to perform needed tasks for the In-Lab requirements
 * 
 * The following is the To-do: list:
 * - Add in Method isEmpty in LList class
 * - Change LLnode and DLLnode data member to type char (did this another way)
 * - Add in the method getdata() in LLNode class
 * - Enter in test data and add in Palindrome checker...
 * 		-Currently it will display if the entered in string is a palindrome or not by
 * 		saying false or true after string is inputed.
 * 		-It will add in regardless if it is a true palindrome or not into the linkedlist
 * 		-Currently doesnt meet the requirement for skipping over special characters or spaces....(TO DO) FIXED
 * - Now checks for spaces FIXED
 * - Doesnt check for special charcters still! ********************
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class LinkedListExample {

	public static void main(String[] args) {
		LList list = new LList();
		Scanner sc = new Scanner(System.in);
		
		String word;
		
		boolean done = false;
		String option = null;
		
		
		
	//	System.out.println("Enter a string: ");
	//	String newData = sc.nextLine();
	//	System.out.println("The string is a "+list.TestPalindrome(newData)+" palindrome");
		

		while (!done) {
			try {
				System.out.println("Enter a to add to head,\n" + "enter d to delete from the head,\n"
						+ "enter l to display a linked list\n"
						+ "enter q to quit:");

				option = sc.nextLine();
				
				if (option.charAt(0) == 'a') {
					System.out.println("Enter a string: ");
					String newData = sc.nextLine();
					word = list.TestTestPalindrome(newData); 
				//	System.out.println("The string is a "+list.TestPalindrome(newData)+" palindrome.\n");
					
					list.addAtHead(newData);
				} else if (option.charAt(0) == 'd') {
					LLNode remove = list.deleteAtHead();
					System.out.println("The removed one is: " + remove);
				} else if (option.charAt(0) == 'l') {
					list.display();
				}
				 else if (option.charAt(0) == 'q') {
					System.out.println("\n\nProgram has been terminated..\nGood Bye");
					done = true;
				} else {
					System.out.println("Invalid option or invalid characters.....Please attempt again!");
				}
				System.out.println();

			} catch (InputMismatchException e) {
				System.err.println("Please enter characters for the menu selection");
				sc.nextLine();
			}
		}
	}

}
