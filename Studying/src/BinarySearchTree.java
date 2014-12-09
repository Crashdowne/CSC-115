import java.util.Random;

public class BinarySearchTree {

	private TreeNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	public TreeNode getRootNode(BinarySearchTree tree) {
		return tree.root;
	}

	// An iterative insert method
	//Insert a new item into a binary search tree
	public void insert(int k, int v) {
		if (this.root == null) {
			this.root = new TreeNode(k,v);
		} else {
			TreeNode parent = root;
			TreeNode child = root;

			while ( child != null) {
				parent = child;
				if ( parent.getKey() > k ) {
					child = child.getLeft();
					if (child == null) 
						parent.setLeft(new TreeNode(k,v));
				}
				else {
					child = child.getRight();
					if (child == null) 
						parent.setRight(new TreeNode(k,v));
				}
			}
		}
	}

	
	//Insert a new item into a binary search tree
	public void insertR(int k, int v) {
		if (this.root == null) 
			this.root = new TreeNode(k,v);
		else 
			insert(root, k, v);
	}

	//Recursively Inserts a new item into a binary search tree
	public void insert(TreeNode t, int k, int v) {

		if (t.getKey() > k ) {
			if (t.getLeft() == null) 
				t.setLeft(new TreeNode(k, v));
			else 
				insert(t.getLeft(), k, v); //recurse right
		} else {
			if (t.getRight() == null) 
				t.setRight(new TreeNode(k, v));
			else 
				insert(t.getRight(), k, v); //recurse left
		}
	}

	//Retrieve the node with a given search key from a binary search tree
	private TreeNode retrieve (int key){
		return null;
	}
	
	//Return the value associated with the given search key from 
	// the binary search tree
	private int search (int searchKey){
		return null;
	}


	//Traverse the items in a binary search tree in preorder, inorder, or postorder
	public String PreOrder() {
		return PreOrder(this.root);
	}

	public String PreOrder(TreeNode top) {
		String result = "";
		return result;
	}

	public String InOrder() {
		return InOrder(this.root);
	}

	public String PostOrder() {
		return InOrder(this.root);
	}

	public String PostOrder(TreeNode top) {
		String result = "";
		return result;
	}

	public String InOrder(TreeNode top) {
		String result = "";
		if (top == null) return result;
		return result += InOrder(top.getLeft()) +
					top.getKey()+":"+top.getValue() + ", " +
					InOrder(top.getRight());
	}

	public int getValOfMaxKey() {
		return -1;
	}
	
	
	public int getValOfMaxKeyR() {
		return doGetValofMaxKey(root);
	}
	
	public int doGetValofMaxKey(TreeNode t) {
		return -1;
	}

	public int getMaxVal() {
			
		return -1;
	}	

	public int getKeyOfMaxVal() {
			
		return -1;
	}	
	
	public static void main (String[] args) {

		//creates BST
		BinarySearchTree tester = new BinarySearchTree();
		
		Random r = new Random();
		
		for(int i=0; i<10; i++)  {
			int k = r.nextInt(100);
			tester.insertR(k, i);
		}

		System.out.println("InOrder: " + tester.InOrder());


		System.out.println("Value of max key is:  " + tester.getValOfMaxKey());
		System.out.println("Value of max key is:  " + tester.getValOfMaxKeyR());
		System.out.println("key  of max value is:  " + tester.getMaxVal());
	}

}
