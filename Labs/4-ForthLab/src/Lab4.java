import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab4 {
	
	public static int search;
	public static void main(String[] args) {
		Numbers numbers = new Numbers();
		int selection = 0;
		int count;
		int choice;
		do {
			try {
		System.out.println("1 ... Create array with new size\n"+
						   "2 ... Generate random numbers and store it in the array\n"+
						   "3 ... Search and display number of occurrences\n"+
						   "4 ... Binary search to find whether specific number exists\n"+
						   "5 ... Recursive binary search to find whether specific number exists\n"+
						   "6 ... Display array\n"+
						   "7 ... Recursive quick sort\n" +
		                   "8 ... Quit");
		Scanner s = new Scanner(System.in);
		selection = s.nextInt();
			switch(selection){
			case 1: 
				System.out.println("Enter required size: ");
				numbers = new Numbers(s.nextInt());
				break;
			case 2: 
				if(numbers.getSize()==0){
					System.out.println("Major Error, Nothing to generate");
					break;
				}
				else {
					numbers.generateNumbers();
					break;
					}
			case 3: 
				if(numbers.getSize()==0){
					System.out.println("Major Error, Nothing to search");
					break;
				}
				else {
					System.out.print("Enter the number to be searched: ");
					choice = s.nextInt();
					count = numbers.count(choice);
					System.out.println("Number of occurrences of "+ choice + " in the current arrays is "+count);
					break;
				}
			case 4: 
				if(numbers.getSize()==0){
					System.out.println("Major Error, Nothing to search or find");
					break;
				}
				else {
					System.out.println("Enter the number to be searched:");
					search = s.nextInt();
					int index = numbers.binSearch();
					if(index != -1)
					System.out.println(search + " is in the list of numbers at the index " + (index + 1) + ".\n");
					else
					System.out.println("Not in the list");
					break;
				}
			case 5:
				
				if(numbers.getSize()==0){
					System.out.println("Major Error, Nothing to search or find");
					break;
				}
				else {
					System.out.println("Enter the number to be searched:");
					search = s.nextInt();
					numbers.recBinarySarch();
					
					break;
				}
				
			case 6:
				if(numbers.getSize()==0){
					System.out.println("Major Error, Nothing to display");
					break;
				}
				else {
				System.out.println(numbers.toString());
				System.out.println();
				break;
				}
			case 7:
				System.out.println("This is recuesive quick sort");
				numbers.recQuickSorts();
				System.out.println("Things are now sorted");
				break;
			case 8:
				System.out.println("exiting");
				System.out.println("Bye.... See you again");
				break;
			default:
				System.out.println("Invalid choice...please reenter...");
				break;
			}
		} catch (InputMismatchException e){
		      System.out.println("Invalid choice...please reenter..."); 
		 } 
	}while (selection!=8);
	}
}
