/*
 * Assignment 2 Array List implementation of PlayerList.
 *
 *
 */
 
public class PlayerArrayList implements PlayerList
{
	private static final int INITIAL_SIZE=1;

	private Player[] storage;
	private int   count;

	public PlayerArrayList ()
	{
		storage = new Player[INITIAL_SIZE];
		count = 0;
	}

	private void growAndCopy()
	{
		Player[] newstorage = new Player[storage.length*2];
		for (int i=0;i<count;i++)
		{
			newstorage[i] = storage[i];
		}
		storage = newstorage;
	}
		

	public void addAt (Player p, int pos)
	{
		if (count == storage.length)
		{
			growAndCopy();
		}
		
		for (int i=count; i > pos; i--)
		{
			storage[i] = storage[i-1];
		}
		storage[pos] = p;

		count++;
	}	
		
	 
	public void append (Player p)
	{
		if (count == storage.length)
		{
			growAndCopy();
		}
		storage[count++] = p;
	}


	public int size()
	{
		return count;
	}

	public Player  get (int pos)
	{
		// Note that there is no verification that pos is 
		// in range due to the preconditions.  
		return storage[pos];
	}

	 
	public int find (Player p)
	{
		for (int i=0;i<count;i++)
		{
			if (storage[i].equals(p))
				return i;
		}
		return -1;		
	}
	 
	public void clear()
	{
		count = 0;
	}


	public void removeAt (int index)
	{
		for (int i = index; i < (count - 1); i++)
		{
			storage[i] = storage[i + 1];
		}
		count--;
	}

	public void remove (Player p)
	{
		int index = find(p);

		while(index != -1) 
		{
			removeAt(index);
			index = find(p);
		}		
	}
	

	public String toString()
	{
		String s = "{";
		for (int i=0;i<count;i++)
		{
			s+= storage[i].toString();
			if (i != (count - 1))
			{
				s+= ",";
			}
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
	
		PlayerArrayList l = new PlayerArrayList();
		
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
