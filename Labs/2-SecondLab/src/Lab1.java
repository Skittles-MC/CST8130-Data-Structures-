import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {

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
						   "4 ... Display array\n"+
		                   "5 ... Quit");
		Scanner s = new Scanner(System.in);
		selection = s.nextInt();
			switch(selection){
			case 1: 
		
				System.out.println("Enter required size: ");
				numbers = new Numbers(s.nextInt());
				break;
			case 2: 
				
				if(numbers.size==0){
					System.out.println("Major Error, Nothing to generate");
					break;
				}
				else {
					numbers.generateNumbers();
					break;
					}
//				if  (numbers.isEmpty()){
//					System.out.println("Major Error, Nothing to generate");
//					numbers.generateNumbers();
//					break;
//				}
//				else {
//				numbers.generateNumbers();
//				break;
//				}
			case 3: 
				if(numbers.size==0){
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
				if(numbers.size==0){
					System.out.println("Major Error, Nothing to display");
					break;
				}
				else {
				System.out.println(numbers.toString());
				System.out.println();
				break;
				}
			case 5:
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
			
			
	}while (selection!=5);
	}
}
