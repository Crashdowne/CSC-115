public class Team
{
	private String name;
	private PlayerList	players;
	
	// Purpose:
	//	initialize this instance of Team
	// 	with no Player
	//
	public Team (String name)
	{
		// You must allocate a PlayerList here

	}
	
	// Purpose:
	//	initialize this instance of Team
	//	add p to the list of phone players associated with 
	//	this Team
	//
	public Team (String name, Player p)
	{
		// You must allocate a PlayerList here

	}

	// Purpose: 
	//	return the name associated with this instance
	//
	public String getName ()
	{
		return "implement this";
	}

	// Purpose:
	//	change the name associated with this instance to be newName
	//
	public void setName(String newName)
	{

	}

	// Purpose:
	//	add a new player to this Team
	//	there is no maximum number of phone players that can be
	//	assigned to a Team.
	//
	public void addPlayer (Player p)
	{

	}

	// Purpose:
	//	remove p from the list of Players associated with this Team
	//	if p is not in the list, do nothing.
	//
	public void removePlayer (Player p)
	{

	}

	// Purpose:
	//	return the count of Players associated with this Team
	//
	public int getPlayerCount()
	{
		return -1;
	}
	
	// Purpose:
	//	return the player at index pos from this Team
	//	
	// Pre-condition:
	//	pos >= 0 AND
	//	pos < this.getPlayerCount()
	//
	public Player getPlayer (int pos)
	{
		// NOTE NOTE NOTE
		// 
		// This line needs to be removed.  It is only
		// so the tester works.  You should NOT
		// allocate a new PhoneNumber in this method
		return new Player("WARNING fix this", -1);
	}

	// Purpose:
	//	return a String representation of this Team	
	//
	public String toString()
	{
		String s = name;
		
		for (int i=0;i<players.size();i++)
		{
			s += "\n";
			s += players.get(i);
		}
		return s;


	}
}
