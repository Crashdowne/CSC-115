import java.util.*;


public class IntegerSLL implements IntegerList {
	
	private LinkedList IntegerSSL;
	private int count;
	private String courseName;
	private Node head;
	
	public void IntegerSSL(String courseName)
	{
		this.IntegerSSL = new LinkedList();
		this.courseName  = courseName;
		this.count = 0;
		head = null;
	}
	
	public void addFront(int value)
	{
		Node nn = new Node(value);
		nn.next = head;
		head = nn;
		count++;
	}
	
	public void addBack(int value)
	{
		Node temp = new Node(value);
		while(temp.next != null)
		{
			temp = temp.next;
		}
		
	}
	
	public int get(int pos)
	{
		

	}
	
	
	public String toString()
	{
		return courseName;
	}
	
	public int size()
	{
		return count;
	}

}
