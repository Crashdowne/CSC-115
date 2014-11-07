
//Fielder class for any field position baseball player
public class Fielder extends Player
{
	private int battingAvg; //#hits/#at bats (H/AB)

	// Purpose:
	// 	Initialize this instance of Fielder
	// 	set the battingAvg to be 0
	//
	public Fielder (String name, String position)
	{
		super(name, position);
		this.battingAvg = 0;
	}

	// Purpose:
	//	Initialize this instance of Fielder
	// 	set the battingAvg to be battingAvg
	//
	public Fielder (String name, String position, int battingAvg)
	{
		super(name, position);
		this.battingAvg = battingAvg;	
	}
	
	// Purpose:
	// 	Change the battingAvg associated with this Fielder
	// 	to be newBattingAvg
	//
	public void setBattingAvg (int newBattingAvg)
	{
		this.battingAvg = newBattingAvg;
	}

	// Purpose:
	//	Return the battingAvg associated with this Fielder
	//
	public int getBattingAvg ()
	{
		return battingAvg;
	}

	
	
}