
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

}
