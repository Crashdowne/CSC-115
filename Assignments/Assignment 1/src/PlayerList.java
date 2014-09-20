public class PlayerList
{
	private static final int INITIAL_SIZE = 2;
	
	private Player[] storage;
	private int count;

	// Creates a new player list array called storage to a set size
	public PlayerList()
	{
		this.storage = new Player[INITIAL_SIZE];
		this.count = 0;
	}
	
	// Gets the player name from the storage array at a specific index
	public Player get (int index)
	{
		return this.storage[index];
	} 

	// Removes a player at a specific index
	public void remove (int index)
	{
		// If index is not included in the elements of the array
		if (index >= count)
		{
			System.out.println("Index out of bounds");
			return;
		}
		
		// If not the last element
		if (index != count-1)
		{
			
			// Replace the element at given index by moving everything 
			// behind it forward by one element
			for (int i = index; i < count-1; i++)
			{
				storage[i] = storage[i+1];
			}
		}
		
		// Count gets decremented to account for the removal of an element / player
		count --;
	}

	// Uses count to report the size of the team
	public int size()
	{
		return this.count;
	}

	// Adds players to the array, checks to see if the array is full
	// Calls isArrayFull to determine if it is indeed full
	// If it is full, calls the method to expand the array
	// Adds a player to the position given by count
	public void add (Player p)
	{
		if(this.isArrayFull())
		{
			this.expandArray();
		}
		storage[count] = p;
		count += 1;
	}
	
	// Checks to see if the array is full or not 
	// If count is equal to the length of the storage array
	private boolean isArrayFull()
	{
		return this.count == this.storage.length;
	}
	
	// Creates a new array, copies the old contents into the new array
	// Sets the memory pointer to the newly created array
	private void expandArray()
	{
		Player[] expandedStorage = new Player[this.storage.length*2];
		
		for (int i = 0; i < count; i++)
		{
			expandedStorage[i] = storage[i];
		}
		
		this.storage = expandedStorage;
	}

	// Compares the names of players in the array to see if there is a match
	// Returns the position in the array of that player
	// If that player does not exist, returns -1
	public int find (Player p)
	{
		for (int i = 0; i < this.count; i++)
		{
			if (p.equals(this.storage[i]))
			{
				return i;
			}
		}
		return -1;
	}

}
