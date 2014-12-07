
public class LLNode {

	private LLNode data;
	private LLNode head;
	private LLNode tail;
	
	public LLNode()
	{
		this.data = null;
		this.head = null;
		this.tail = null;
	}
	
	public LLNode(LLNode data)
	{
		this.data = data;
		this.head = null;
		this.tail = null;
	}
	
	public LLNode(LLNode data, LLNode head, LLNode tail)
	{
		this.data = data;
		this.head = head;
		this.tail = tail;
	}
	
	public LLNode get()
	{
		return this.data;
	}
	
	public void set(LLNode newData)
	{
		this.data = newData;
	}
}
