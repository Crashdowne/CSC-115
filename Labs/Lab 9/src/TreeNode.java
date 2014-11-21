class TreeNode{
    //This class stores Oject data and references to its left and right tree nodes.
	private Object data;
	private TreeNode left;
	private TreeNode right;
	
	TreeNode(Object newData){
		this.data = newData;
	}

	public TreeNode getLeftChild(){
	   return this.left;
	}

	public TreeNode getRightChild(){
	   return this.right;
	}

	public Object getData(){
	   return this.data;
	}

	public void setData(Object newData){
		this.data = newData;
	}

	public void setLeftChild(TreeNode left){
		this.left = left;
	}

	public void setRightChild(TreeNode right){
		this.right = right;
	}

	public String toString(){
		return this.data.toString();
	}

	public static void main(String[] args){
		TreeNode test = new TreeNode(10);
		System.out.println(test);
	}
}