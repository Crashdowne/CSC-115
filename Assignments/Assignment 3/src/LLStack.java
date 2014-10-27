/*
 * CSC 115 Assignment 3
 * Bryan Kesteloo
 * V00718963
 * Creates a Stack implementing the Stack interface, using a singly linked-list structure
 */

public class LLStack<T> implements Stack<T>
{
	private int size;
	private Node <T> top;
	
	public LLStack()
	{
		top = null;
		size = 0;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean empty()
	{
		if (this.size == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void push(T object)
	{
		Node<T> nn = new Node<T>(object);
		
		if(empty() == true)
		{
			this.top = nn;
			size++;
		}
			
		else
		{
			nn.setNext(top);
			this.top = nn;
			size++;
		}
	}
	
	public void makeEmpty()
	{
		this.top = null;
		size = 0;
	}

	public T pop() throws StackEmptyException
	{
		if(this.empty() == true)
		{
			throw new StackEmptyException("The stack is empty");
		}
		
		T topItem = this.top.getData();
		this.top = this.top.getNext();
		this.size--;
		return topItem;
	}
	
	public T peek()
	{
		return this.top.getData();
	}
}

