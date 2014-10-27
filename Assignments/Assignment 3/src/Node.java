/*
 * CSC 115 Assignment 
 * Bryan Kesteloo
 * V00718963
 * Creates a node template to be implemented by LLStack
 */
public class Node<T> 
{

	private Node<T> next;
	private T data;

	public Node()
	{
		next = null;
	}
	
	public Node(T newData){
		data = newData;
		next = null;
	}

	public T getData(){
		return data;
	}

	public Node<T> getNext(){
		return next;
	}

	public void setData(T newData){
		data = newData;
	}

	public void setNext(Node<T> newNext){
		next = newNext;
	}

	public String toString(){
		return data.toString();
	}
}
