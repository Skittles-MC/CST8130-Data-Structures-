import java.util.InputMismatchException;
import java.util.Scanner;
public class BinaryTreeExample {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
//		Scanner sc = new Scanner(System.in);
//		boolean done = false;
//		String option = null;
		int selection = 0;
		
		//tree.insertInTree(7);
	//	tree.insertInTree(16);
		//tree.insertInTree(9);
	//	tree.insertInTree(27);
//		tree.insertInTree(5);
//		tree.insertInTree(14);
//		tree.insertInTree(23);
	//	tree.insertInTree(6);
	//	tree.insertInTree(3);
	//	tree.insertInTree(9);
	//	tree.insertInTree(1);
	//	tree.insertInTree(15);
	//	tree.insertInTree(7);
	//	tree.insertInTree(14);

		
		
		
		
/***
//		System.out.println("\nPre order: ");
//		tree.displayPreOrder();
//		
//		System.out.println("In order: ");
//		tree.displayInOrder();
//		
//		//tree.postOrderTraversalDisplay(tree.root);
//		
//		
//		
//		
//		System.out.println("\nPos order: ");
//		tree.displayPosOrder();
//
//		 System.out.println();
//			System.out.println("\nThe height of tree is " + tree.height(tree.root));	
//		You should have five options in your menu – insert into the tree,
//		pre-order traversal, in-order traversal, post-order traversal, and height of the tree.
//		 We should be able to create new trees 
//		and get the corresponding outputs.
//		while (!done) {
//			try {
//				System.out.println("Enter a to insert into the tree\n" + "Enter b to pre-order traversal\n"
//						+ "enter c to in-order traversal\n" + "Enter d for post-order traversal\n" 
//						+ "Enter e for height of the tree of current tree\n"
//						+ "Enter q to quit:");
//
//				option = sc.nextLine();
//				
//				if (option.charAt(0) == 'a') {
//					 System.out.println("Enter integer element to insert");	
//					// tree.insertInTree( sc.nextInt() );
//					 int newData = sc.nextInt();
//					 tree.insertInTree(newData);
//				} 
//				
//				else if (option.charAt(0) == 'b') {
//					System.out.println("\nPre order: ");
//					tree.displayPosOrder();
//				} 
//				
//				else if (option.charAt(0) == 'c') {
//					System.out.println("In order: ");
//					tree.displayInOrder();
//				} 
//				
//				else if (option.charAt(0) == 'd') {
//					System.out.println("\nPost order: ");
//					tree.displayPosOrder();
//				} 
//				else if (option.charAt(0) == 'e') {
//					System.out.println("\nThe height of tree is " + tree.height(tree.root));
//				}
//				else if (option.charAt(0) == 'q') {
//					System.out.println("\n\nProgram has been terminated..\nGood Bye");
//					done = true;
//				} else {
//					System.out.println("Invalid option or invalid characters.....Please attempt again!");
//				}
//				System.out.println();
//
//			} catch (InputMismatchException e) {
//				System.err.println("Please enter characters for the menu selection");
//				sc.nextLine();
//			}
//		}
**/
		do {
			try {
		System.out.println("1 ... To insert into the tree\n"+
						   "2 ... For pre-order traversal\n"+
						   "3 ... For in-order traversal\n"+
						   "4 ... For post-order traversal\n"+
						   "5 ... For height of the tree\n"+
		                   "6 ... Quit");
		Scanner s = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		selection = s.nextInt();
		switch(selection){
		case 1: 
			System.out.println("Enter integer element to insert");	
//			 tree.insertInTree( sc.nextInt() );
			 int newData = sc.nextInt();
			 tree.insertInTree(newData);
			break;
		case 2:
			System.out.println("\nPre order: ");
			tree.displayPreOrder();
				break;
			
		case 3: 
			System.out.println("In order: ");
			tree.displayInOrder();
				break;
		case 4: 
			System.out.println("\nPost order: ");
			tree.displayPosOrder();
				break;
		case 5:
			System.out.println("\nThe height of tree is " + tree.height(tree.root));
			break;
		case 6:
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
}while (selection!=6);
		
	}
}		
