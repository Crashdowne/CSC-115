/*
 * Assignment 2 Doubly-Linked List implementation of PlayerList.
 *
 *
 */

public class PlayerLinkedList implements PlayerList

{
	private PlayerNode	head;
	private PlayerNode	tail;
	
	private	int	count;

	public PlayerLinkedList()
	{
		head = null;
		tail = null;
		count = 0;
	}
	
	public boolean isListEmpty()
	{
		if(count == 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public boolean isBeginningOfList(int pos)	
	{
		if(pos == 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	public void addAt (Player p, int pos)
	{	
		if(pos < 0)
		{
			System.out.println("Position cannot be less than 0");
			return;
		}
		
		if(pos > count)
		{
			System.out.println("Position cannot be greater than or equal to "+count);
			return;
		}
		
		PlayerNode newNode = new PlayerNode(p);
		PlayerNode currentNode;

		
		if(isListEmpty() == true)
		{
			head = newNode;
			tail = newNode;

		}
		
		else if(isBeginningOfList(pos) == true)
		{
			newNode.next = head;
			head = newNode;	
		}
		
		else
		{
			currentNode = head;
			for(int i=0; i<pos-1; i++)
			{
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
		
		count ++;
	}

	public void append (Player p)
	{
		PlayerNode newNode = new PlayerNode(p);
		if(isListEmpty() == true)
		{
			head = newNode;
			tail = newNode;
			count++;
		}

		else
		{
			tail.next = newNode;
			tail = newNode;
			count++;
		}
	}

	public int size()
	{
		return count;
	}
	

	public Player  get (int pos)
	{
		PlayerNode currentNode = new PlayerNode();
		currentNode = head;
		for(int i=0; i<pos; i++)
		{
			currentNode = currentNode.next;	
		}
		return currentNode.p;
	}

	public int find (Player p)
	{
		//PlayerNode newNode = new PlayerNode(p);
		PlayerNode currentNode;
		currentNode = head;
		int index=0;
		
		for(int i=0; i<count; i++)
		{			
			if(currentNode.getPlayer().equals(p))
			{
				return index;	
			}
			currentNode = currentNode.next;
			
			index++;
		}
		return -1;
	}
	 
	public void clear()
	{
		head = null;
		tail = null;
		this.count = 0;
	}
	
	public void removeAt (int pos)
	{
		PlayerNode currentNode;
		currentNode = this.head;
		
		if(pos < 0)
		{
			System.out.println("Position cannot be less than 0");
			return;
		}
		
		if(pos > count)
		{
			System.out.println("Position cannot be greater than equal to "+count);
			return;
		}
		
		if(count == 1)
		{
			clear();
		}
		
		if(pos == 0)
		{
			
			this.count--;
		}
		
		if(pos > 0)
		{
			for(int i=0; i<pos-1; i++)
			{
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
			this.count--;
		}
		
		
	}
	 
	public void remove (Player p)
	{
		PlayerNode currentNode;
		currentNode = head;
		
		for(int i=0; i<count; i++)
		{
			if(p.equals(currentNode))
			{
				currentNode.next = currentNode.next.next;
			}
			currentNode = currentNode.next;
		}
		count--;

	}

	public String toString()
	{
		PlayerNode currentNode;
		currentNode = head;
		int index=0;
		String s = "{";
		
		if(isListEmpty() == true)
		{
			return "{}";
		}
		s+=currentNode.getPlayer().toString();
		
		while(currentNode.next != null)
		{
			if(index < count)
			{
				s+=",";
			}	
			currentNode = currentNode.next;
			s+=currentNode.getPlayer().toString();
			index++;
		}
		
		s+= "}";
		return s;
	}
	
	/*
	 * Here you see some basic testing I did before moving on to
	 * the more detailed testing provided by a2tester.java
	 *
 	 * You can run this by typing:
	 * javac PlayerArrayList.java
 	 * java PlayerArrayList
	 *
	 */
	public static void main (String[] args)
	{
	
		PlayerLinkedList l = new PlayerLinkedList();
		
		System.out.println(l);
		l.append(new Player("one"));
		l.append(new Player("two"));
		l.append(new Player("ten"));
		l.append(new Player("five"));
		System.out.println(l);
		System.out.println();
		
		l.clear();
		System.out.println(l);
		System.out.println();
		
		l.addAt(new Player("one"),0);
		l.addAt(new Player("two"),0);
		l.addAt(new Player("ten"),0);
		l.addAt(new Player("five"),2);
		System.out.println(l);
		System.out.println();
	}


}

