public class Team
{
	private String name;
	private PlayerList	players;
	
	// Initialize our Player List
	public Team (String name)
	{
		this.name = name;
		this.players = new PlayerList();

	}
	
	// Initializes a team with a Player List that has players
	public Team (String name, Player p)
	{
		this.name = name;
		this.players = new PlayerList();
		this.players.add(p);
	}

	// Returns the name of the current Team object
	public String getName ()
	{
		return name;
	}

	// Changes the name of the current Team object
	public void setName(String newName)
	{
		this.name = newName;
	}

	// Adds a player to PlayerList by calling add
	public void addPlayer (Player p)
	{
		this.players.add(p);
	}

	// Removes a player from the Player List by calling the remove method in PlayerList
	public void removePlayer (Player p)
	{
		int player = this.players.find(p);
		players.remove(player);

	}

	// Gets the number of players
	public int getPlayerCount()
	{
		return this.players.size();
	}
	
	// Gets the name of a player in a specific position in the PlayerList
	public Player getPlayer (int pos)
	{
		return this.players.get(pos);
	}

	// Returns information about the team
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
