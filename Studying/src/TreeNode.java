public class TreeNode {
	//attributes
	private int key;
	private int	value;
	private TreeNode left;
	private TreeNode right;

	//constructors
	public TreeNode() {
		this.left = null;
		this.right = null;
	}
	public TreeNode(int key, int value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}

	//assessors & mutators
	public int getKey() {
		return this.key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeft() {
		return this.left;
	}
	public void setLeft(TreeNode newLeft) {
		this.left = newLeft;
	}
	public TreeNode getRight() {
		return this.right;
	}
	public void setRight(TreeNode newRight) {
		this.right = newRight;
	}
}



