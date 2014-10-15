import java.util.*;


public class IntegerSLL implements IntegerList {
	
	private LinkedList IntegerSLL;
	private int count;
	private String courseName;
	private Node head;
	private Node tail;
	
	public IntegerSLL(String courseName) 
	{
		this.IntegerSLL = new LinkedList();
		this.courseName  = courseName;
		this.count = 0;
		head = null;
	}
	
	public void addFront(int value)
	{
		Node nn = new Node(value);
		Node tracker = head;
		nn.next = tracker;
		head = nn;
		count++;
	}
	
	public void addBack(int value)
	{
		Node nn = new Node(value);
		Node tracker = head;
		
		for(int i=0; i<count-1; i++)
		{
			//tracker = tracker.next;
		}
		tracker = nn;
		tail = nn;
		this.count++;
	}
	
	public int get(int pos)
	{
		Node nn = head;
		
		for(int i=0; i<pos-1; i++)
		{
			nn = nn.next;
		}
		return nn.getData();
	}
	
	
	public String toString()
	{
		return courseName;
	}
	
	public int size()
	{
		return count;
	}

	public void clear() {
		head = null;
		tail = null;
		count = 0;	
	}

	public void remove(int value) {
		Node nn = head;
		
		for(int i=0; i<value-1; i++)
		{
			nn = nn.next;
		}
		nn = nn.next.next;
		count--;
	}

}
