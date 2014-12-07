import java.util.*;


public class LLStudying <T> implements LLInterface <T> 
{
	
	private int size = 0;
	private LLNode <T> head;
	private LLNode <T> tail;

	public int size()
	{
		return this.size;
	}
	
	public static void find()
	{
		
	}
	
	public boolean empty() 
	{
		if(size == 0)
		{
			return true;
		}
		return false;
	}

	
	public void makeEmpty() 
	{
		this.head = null;
		this.tail = null;
	}

	public void insertFront(T data) 
	{
		LLNode <T> nn = new LLNode<T>(data);
		if (empty())
		{
			head = nn;
			tail = nn;
			size++;
		}
		else
		{
			nn.setNext(tail);
			tail = nn;
			size++;
		}	
	}

	public void insertBack(T data) 
	{
		LLNode<T> nn = new LLNode<T>(data);
		if (empty())
		{
			tail.setNext(nn);
			tail = nn;
			size++;
		}
	}

	public void removeFront() throws StackEmptyException
	{
		if(empty())
		{
			throw new StackEmptyException ("Stack is Empty");
		}
		else
		{
			head.setNext(head.getNext());
			size--;
		}
	}

	public void removeBack() throws StackEmptyException
	{
		if(empty())
		{
			throw new StackEmptyException ("Stack is Empty");
		}
		else
		{
			LLNode<T> tmp = new LLNode();
			LLNode<T> prev = new LLNode();
			tmp.setNext(head);
			while (tmp.getNext() != tail)
			{
				prev.getNext();
			}
			prev.setNext(prev);
			tail = prev;
		}
		
	}

	public void removeSecondLast() 
	{
		LLNode<T> tmp = new LLNode();
		LLNode<T> prev = new LLNode();
		tmp.setNext(head.getNext());
		while (tmp.getNext() != tail)
		{
			prev.getNext();
		}
		prev.setNext(prev.getNext());
		tail = prev;
	}
}
