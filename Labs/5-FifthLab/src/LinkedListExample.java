import java.util.InputMismatchException;
import java.util.Scanner;
public class LinkedListExample {

	public static void main(String[] args) {
		LList list = new LList();
		Scanner sc = new Scanner(System.in);
		
		boolean done = false;
		String option = null;
/***************Old sample code from PDF**************************
//		list.addAtHead("Linda");
//		list.addAtHead("George");
//		System.out.println("The list is ");
//		list.display();
//		
//		LLNode removedOne = list.deleteAtHead();
//		System.out.println("After delete, the list is ");
//		list.display();
//		System.out.println("The one deleted is..." + removedOne); 
*/
		while (!done) {
			try {
				System.out.println("Enter a to add to head,\n" + "enter d to delete from the head,\n"
						+ "enter l to display a linked list\n" + "enter r to delete a particular element in the list\n"
						+ "enter q to quit:");

				option = sc.nextLine();
				
				if (option.charAt(0) == 'a') {
					System.out.println("Enter a string to add to the list");
					String newData = sc.nextLine();
					list.addAtHead(newData);
				} else if (option.charAt(0) == 'd') {
					LLNode remove = list.deleteAtHead();
					System.out.println("The removed one is: " + remove);
				} else if (option.charAt(0) == 'l') {
					list.display();
				} else if (option.charAt(0) == 'r') {
					System.out.println("Enter a string to delete from the list");
					String data = sc.nextLine();
					list.deleteAtElement(data);
				} else if (option.charAt(0) == 'q') {
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
