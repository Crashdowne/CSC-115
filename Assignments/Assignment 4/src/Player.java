/*
 * Player
 * Bryan Kesteloo
 * V00178963
 * 
 */
public class Player implements Comparable<Player>
{	
	private String name;
	private String position; //positions: 1B 2B 3B LF RF CF SS C P

	// Purpose:
	// 	Initialize this instance of Player
	// 	set the position to the empty string
	//
	public Player (String name)
	{
		this.name = name;
		this.position = "";
	}

	// Purpose:
	// 	Initialize this instance of Player
	//	
	public Player (String name, String position)
	{
		this.name = name;
		this.position = position;
	}

	// Purpose:
	// 	Change the name associated with this Player
	// 	to be newName
	//
	public void setName (String newName)
	{
		name = newName;
	}

	// Purpose:
	//	Return the name associated with this Player
	//
	public String getName()
	{
		return name;
	}
	
	// Purpose:
	// 	Change the position associated with this Player
	// 	to be newPosition
	//
	public void setPosition(String newPosition)
	{
		this.position = newPosition;
	}

	// Purpose:
	//	Return the position associated with this Player
	//
	public String getPosition()
	{
		return position;
	}
		
	// Purpose:
	//	Compare this instance of Player to other
	//	return true if they are the same.
	//	
	//	We consider two Players to be equal if
	//	their names are the same.  
	//
	// Pre-conditions:
	//	other is not null
	//
	// Returns:
	//	true	if this instance's name are the same as
	//		other's name
	//	false	otherwise
	//
	public boolean equals (Player other)
	{
		return	name.equals(other.getName());
	}

	// Purpose:
	//	Return a String representation of this Player
	// 
	// Returns:
	//	name: position
	//	
	public String toString()
	{
		return name + ":\t" + position ;
	}

	// Purpose:
	//	Compare this instance of Player to other where,
	//  comparison is alphabetical on Player's name.
	//	
	//	HINT:  
	//	String implements the compareTo method just like it implements
	//	the equals method, leveraged above in the equals method
	//
	// Pre-conditions:
	//	other is not null
	//
	// Returns:
	//	a negative integer, zero, or a positive integer as this object is 
	//	less than, equal to, or greater than the specified object respectively.
	//	
	public int compareTo(Player other)
	{
		return name.compareTo(other.getName());
	}
}
