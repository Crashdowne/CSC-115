
public class LLNode <T> {

	private  T data;
	private LLNode <T> head;
	private LLNode <T> tail;
	private LLNode <T> next;
	
	public LLNode()
	{
		this.head = null;
		this.tail = null;
		this.head = null;
		this.next = null;
	}
	
	public LLNode(T data)
	{
		this.data = data;
		this.head = null;
		this.tail = null;
		this.next = null;
	}
	
	public T get()
	{
		return this.data;
	}
	
	public LLNode<T> getTail()
	{
		return this.tail;
	}
	
	public LLNode<T> getHead()
	{
		return this.head;
	}
	
	public void setData(T newData)
	{
		this.data = newData;
	}
	
	public void setTail(LLNode<T> newTail)
	{
		this.head = newTail;
	}
	
	public void setHead(LLNode<T> newHead)
	{
		this.head = newHead;
	}
	
	public void setNext(LLNode<T> newNext)
	{
		this.next = newNext;
	}
	
	public LLNode<T> getNext()
	{
		return this.next;
	}
	
	public String toString()
	{
		return data.toString();
	}
}
