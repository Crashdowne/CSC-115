public class BinarySearchTree{
	// Keeps track of the root node of the BinarySearchTree.
	private TreeNode root;

	// Keeps track of the number of TreeNodes in the BinarySearchTree.
	private int size;

	// Creates an empty binary search tree.
	public BinarySearchTree(){
		this.root = null;
		this.size = 0;
	}

	public TreeNode getRoot(){
		return this.root;
	}

	public int getSize(){
		return this.size;
	}

	public boolean isEmpty(){
	   //Complete this method
	   if (this.root == null)
	   {
		   return true;
	   }
	   
	   else
	   {
		   return false;
	   }
	}

	// Entry way to insert.  The user passes in a piece of data to be inserted into the
	// binary search tree.
   public void insert(Object newItem){
		// FILL IN THIS METHOD
		// Special case: if tree is empty, all we need to do is put the item in a node and make
		// it the root of the BST.
		// Otherwise, call recursiveInsert to insert newItem at the correct position in the BST.
      if(isEmpty())
      {
    	  root = new TreeNode(newItem);
    	  size++;
      }
         
      else
      {
    	  recursiveInsert(root, newItem);
	  }
   }

	// Recursive algorithm that finds the correct place to insert newItem in the binary search tree.  Operates like search,
	// except we look down the subtrees before going down them, since we need to store the node
	// *before* we hit a null connection in order to add to the BST.
	private void recursiveInsert(TreeNode current, Object newItem){
		
		// No duplicates
		if (newItem.toString().compareTo(current.toString()) == 0)
		{
			return;
		}
		
		else if (newItem.toString().compareTo(current.toString()) < 0)
		{
			if (current.getLeftChild() == null)
			{
				TreeNode nn = new TreeNode(newItem);
				current.setLeftChild(nn);
				size++;
			}
			
			else
			{
				recursiveInsert(current.getLeftChild(), newItem);
			}
			
		}
		
		else if (newItem.toString().compareTo(current.toString()) > 0)
		{
			if (current.getRightChild() == null)
			{
				TreeNode nn = new TreeNode(newItem);
				current.setRightChild(nn);
				size++;
			}
			
			else
			{
				recursiveInsert(current.getRightChild(), newItem);
			}
			
		}
		// FILL IN THIS METHOD
		// Assume there will be no duplicate values.
		// If newItem is less than value at current node, look down left subtree.
		// If left child is not null, recurse left.  If left child is
		// null, insert new item as the left child.

		// If newItem is greater than value at current node, look down right subtree.
		// If right child is not null, recurse right.  If right child is
		// null, insert new item as the right child.
	}

	public int height(){
		return recursiveHeight(root);
	}

	private int recursiveHeight(TreeNode current){
		if (current == null)
		{
			return 0;
		}
		
		else
		{
			int L = recursiveHeight(current.getLeftChild());
			int R = recursiveHeight(current.getRightChild());
			return 1 + Math.max(L, R);
		}
	}

	// The entry way to the search.  The user calls search and passes in an item, and the
	// search will either return that item (if it is in the tree) or a null
	// (if target is not in the tree).
	public Object search(Object target){
		return search(this.getRoot(), target);
	}

	// Recursive search method for finding a target in a BinarySearchTree.  Compares the current node
	// with the target, goes down left subtree if current node is 'bigger' than target, down right
	// subtree if current node is 'smaller'.
	private Object search(TreeNode current, Object target){
		// If current is null, we have reached the bottom of this path.
		// The target is therefore not in the tree and null is returned.
		if (current == null){
			return null;
		}else{
			// We have found the target, return it.
			if (target.toString().compareTo(current.getData().toString()) == 0){
				return current.getData();
			}
			// Target is 'smaller' than the current node, recurse to the left.
			else if (target.toString().compareTo(current.getData().toString()) < 0){
				return search(current.getLeftChild(), target);
			}
			// Target is 'bigger' than the current node, recurse to the right.
			else{
				return search(current.getRightChild(), target);
			}
		}
	}
	
	public String traversalInOrder(){
		return recursiveInOrder(root);
		
	}
	
	private String recursiveInOrder(TreeNode current){
		
		if (current == null)
		{
			return "";
		}
		
		else
		{
			String result = "";
			result += recursiveInOrder(current.getLeftChild());
			result += current.toString() + " ";
			result += recursiveInOrder(current.getRightChild());
			return result;
		}
		
	}
	
	public String traversalLevelOrder(){

		Queue q = new Queue();
		q.enqueue(root);
		String result = "";
		
		while (q.isEmpty() == false)
		{
			TreeNode temp = (TreeNode) q.dequeue();
			result += temp;
			
			if (temp.getLeftChild() != null)
			{
				q.enqueue(temp.getLeftChild());
				result += " ";
			}
			
			if (temp.getRightChild() != null)
			{
				q.enqueue(temp.getRightChild());
				result += " ";
			}
			
		}
		
		return result;
	}

	public static void main(String[] args){
	    BinarySearchTree bst = new BinarySearchTree();
		
		
	    //Section 01
		bst.insert(30);
		bst.insert(40);
		bst.insert(25);
		bst.insert(15);
		bst.insert(27);
		bst.insert(55);
		bst.insert(42);
		

		
		//Section 02
		System.out.println("Size of the tree: " + bst.getSize());
		System.out.println("Height of the tree: " + bst.height());
		
		
		
		//Section 03
		System.out.println("InOrder traversal should be in ascending order: " + bst.traversalInOrder());
		

		// Visualizes the tree - useful for debugging purposes.
		DrawableBSTree figure = new DrawableBSTree(bst);
		figure.showFrame();
		
		System.out.println("LevelOrder traversal: " + bst.traversalLevelOrder());
	}
}