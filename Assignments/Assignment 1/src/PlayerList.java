public class PlayerList
{
	private static final int INITIAL_SIZE = 2;
	
	private Player[] storage;
	private int count;

	//
	// Purpose:
	//	Initialize a new instance of PlayerList
    // of size INITIAL_SIZE and
    // count initialized to 0
	//
	public PlayerList()
	{
		
	}

	//
	// Purpose: 
	// 	return the element at position index
	//
	// Pre-Conditions:
	// 	for a PlayerList x:
	//	index >= 0 AND
	//	index < x.size()
	//
	// Examples:
	//
	// If x is {"Derek Jeter:300", "Jose Bautista:400", "Michael Saunders:250"} then:
	//	x.get(0) returns "Derek Jeter:300"
	//	x.get(1) returns "Jose Bautista:400"
	//	the result of calling x.get(3) is undefined
	//
	public Player get (int index)
	{
		// NOTE NOTE NOTE
		// 
		// This line needs to be removed.  It is only
		// so the tester works.  You should NOT
		// allocate a new PhoneNumber in this method
		return new Player("WARNING fix this", -1);
	} 

	//
	// Purpose:
	//	remove the element at position index
	//
	// Pre-Conditions:
	//	for a PlayerList x:
	//		index >= 0 AND
	//		index < x.size()
	//
	// If x is {"Derek Jeter:300", "Jose Bautista:400", "Michael Saunders:250"} then
	//	after x.remove(0), x is {"Jose Bautista:400", "Michael Saunders:250"}
	//
	public void remove (int index)
	{

	}

	//
	// Purpose:
	//	return the number of elements in the list
	//
	// Returns:
	//	the number of elements in the list
	//
	// Examples:
	//
	// If x is {"Jose Bautista:400", "Michael Saunders:250"}
	//	x.size() returns 2
	// If x is {}
	//	x.size() returns 0
	//
	public int size()
	{
		return -1;
	}

	// 
	// Purpose:
	//	add the player p to the list
	//
	// Comments:
	//
	//	The array you allocated to store Players might
	//	get full, but you are still required to add this
	//	Player (until the JVM runs out of memory!)
	//	
	//	This means that you should check to see if the array
	//	is currently full.  If it is, allocate a new array
	// 	that is twice as big, then copy the values over
	//	and update the storage reference to be the new array
	//	Finally, add the new Player.
	//
	public void add (Player p)
	{

	}

	//
	// Purpose:
	//	return the index where p is in the list, -1 otherwise
	//
	// Pre-Conditions:
	//	none
	//
	// Returns:
	//	true - if p is in the list
	//	false - if p is not in the list
	//
	// Examples:
	//	
	// If x is {"Derek Jeter:300", "Jose Bautista:400", "Michael Saunders:250"} then
	//
	//	Player p = new Player("Derek Jeter");
	//	Player q = new Player("Michael Saunders");
	//	Player r = new Player("Nelson Cruz");
	//	
	// 	x.find(p) returns 0
	//	x.find(q) returns 2
	//	x.find(r) returns -1
	//
	public int find (Player p)
	{
		return -1;		
	}

}
