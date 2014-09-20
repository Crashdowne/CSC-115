/* Assignment 1
 * CSC 115
 * Bryan Kesteloo
 * V00718963
 * 
 * Purpose:
 * To create a fantasy baseball team by implementing classes
 */



public class Player
{
	private String name;
	private int battingAvg;

	// Creates an object of type player
	public Player (String name)
	{
		this.name = name;
	}

	// Initialized the Player object
	public Player (String name, int battingAvg)
	{
		this.name = name;
		this.battingAvg = battingAvg;
	}

	// Sets the name for the player 
	public void setName (String newName)
	{
		this.name = newName;
	}

	// Gets the player name
	public String getName()
	{
		return name;
	}

	// A setter for the batting average, takes in a new batting average
	// Sets it to the private batting average
	public void setBattingAvg (int newBattingAvg)
	{
		this.battingAvg = newBattingAvg;
	}

	// A getter for the batting average
	public int getBattingAvg()
	{
        return battingAvg;
	}

	// Checks to see if the name given is the same as a player passed in
	public boolean equals (Player other)
	{
		// Makes sure there is a name
		if (other != null)
		{
			// Checks the player names against each other
			if (this.name.equals(other.name))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
	}

	// Prints out the name and batting average when called
	public String toString()
	{
			return this.name+":"+this.battingAvg;
	}
}
