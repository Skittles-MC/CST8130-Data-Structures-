
public class BinaryTree {
	BinaryTreeNode root = null;
	
	public void insertInTree(int newData) {
		if (root == null)
			root = new BinaryTreeNode(newData);
		else
			root.insert(newData);
	}
	
//    public boolean isEmpty()
//    {
//        return root == null;
//    }
    
	public void displayInOrder() {
		displayInOrder(root);
	}
	
	public void displayInOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		displayInOrder(subRoot.getLeft());
		System.out.println(" " + subRoot.getData() + " ");
		displayInOrder(subRoot.getRight());
	}
	
	public void displayPreOrder() {
		displayPreOrder(root);
	}
	
	public void displayPreOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		System.out.println(" " + subRoot.getData() + " ");
		displayPreOrder(subRoot.getLeft());
		displayPreOrder(subRoot.getRight());
	}	

	public void displayPosOrder() {
		displayPosOrder(root);
	}
	
	public void displayPosOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		displayPosOrder(subRoot.getLeft());
		displayPosOrder(subRoot.getRight());
		System.out.println(" " + subRoot.getData() + " ");
	}
	
	public int height(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		} else {
			// calculate the height of each subtree
			int leftDepth = height(node.getRight());
			int rightDepth = height(node.getLeft());
			
			// compare left, right which one is bigger, then add 1
			if (leftDepth > rightDepth)
				return (leftDepth + 1);
			else 
				return (rightDepth + 1);
		}
	}
	
}
