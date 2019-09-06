
public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	
	public BinaryTreeNode() {
		left = null;
		right = null;
		data = 0;
	}
	
	public BinaryTreeNode(int data) {
		left = null;
		right = null;
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public BinaryTreeNode getLeft() {
		return left;
	}
	
	public BinaryTreeNode getRight() {
		return right;
	}
	
	public void insert(int newData) {
		if (newData < data) {
			if (left == null)
				left = new BinaryTreeNode(newData);
			else 
				left.insert(newData);
			
		} else if (newData > data) {
			if (right == null)
				right = new BinaryTreeNode(newData);
			else
				right.insert(newData);
		} else
			System.out.println("Duplicate - not adding..." + newData);
	}

}
