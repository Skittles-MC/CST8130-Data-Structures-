import java.util.Scanner;

public class LList {
	private LLNode head;
	
	public LList() {
		head = null;
	}
	public void addAtHead (String newData) {
		LLNode newNode = new LLNode (newData);
		newNode.updateNode(head);
		head = newNode;
		System.out.println("Success! Added to the head.");
	}
	
	public void display() {
		LLNode temp = head;

		if (head == null) {
			System.out.println("Nothing to display at all");
		} else {
			while (temp != null) {
				System.out.println(temp);
				temp = temp.getNext();
			}
		}
	}
	
	public LLNode deleteAtHead ( ) {
		LLNode removedOne = head;
		if (head == null) {
			System.out.println("Nothing to delete at head..Ignore below statement.");
		} else {
			head = head.getNext();
			System.out.println("Success! Deleted at the head.");
		}

		return removedOne;
	}
	
	
	public void deleteAtElement(String data) {
		LLNode temp;

		if (head == null) {
			System.out.println("Nothing to delete at element or nothing at head.");
		} else {
			temp = head;
			if (temp.toString().equals(data)) {
				head = temp.getNext();	
			} else {
				LLNode link = temp;

				while (temp.getNext() != null) {
					link = temp;
					temp = temp.getNext();

					if (temp.toString().equals(data)) {
						link.updateNode(temp.getNext());
						break;
					}
				}
			}
			System.out.println("Process has been completed");
		}
	}
	
	
	//add in method isEmpty
	 public boolean isEmpty()
	   {
	      return head == null;
	   }
	
//	public boolean TestPalindrome(String s){
//		if (s.length() <= 1) // Base case  4 
//			return true;
//		else if (s.charAt(0) != s.charAt(s.length() - 1)) // Base case  6
//			return false;
//		else
//			 return  TestPalindrome(s.substring(1, s.length() - 1));
//	}	
//new Testing here which checks for space characters 
	public String TestTestPalindrome(String word){
		int x;
		int b = 0;
		int i = 0;

		char letter;

		Scanner input = new Scanner(System.in);
		word = word.replaceAll("\\s+", "");
		word = word.toLowerCase();

		x = word.length()-1;
		while (i <= x){

		    if ((letter = word.charAt(i)) == (letter = word.charAt(x-i))){
		        b += 1;
		    }
		    i += 1;
		}
		if (b == (x+1)){
		    System.out.println("The word IS a palindrome");
		}
		else{
		    System.out.println("The word is NOT a palindrome");
		}
		return word;
	}
}
