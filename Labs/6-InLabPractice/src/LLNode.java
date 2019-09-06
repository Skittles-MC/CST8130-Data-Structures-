
public class LLNode {
	private String data;
	private LLNode next;
	
	public LLNode() {
		this.data = null;
		this.next = null;
	}
	public LLNode (String newData) {
		this.data = (newData);
		this.next = null;
	}
	public void updateNode (LLNode nextOne) {
		this.next = nextOne;
	}
	public String toString () {
		return  data;
	}
	public LLNode getNext() {
		return this.next;
	}
	public String getData(){
		return data;
	}
}
