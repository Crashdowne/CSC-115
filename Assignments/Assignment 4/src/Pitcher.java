public class Pitcher extends Player
{

	private float era;  //Earned run average

	// Purpose:
	// 	Initialize this instance of Pitcher
	// 	set the era to be 0, position to "P"
	//
	public Pitcher (String name)
	{
		super(name, "P");
		this.era = 0;
	}

	// Purpose:
	//	Initialize this instance of Pitcher
	// 	set the era to be era, position to "P"
	//
	public Pitcher (String name, float era)
	{
		super(name, "P");
		this.era = era;
	}

	// Purpose:
	// 	Change the era associated with this Pitcher
	// 	to be newERA
	//
	public void setERA (float newERA)
	{
		this.era = newERA;
	}

	// Purpose:
	//	Return the era associated with this Pitcher
	//
	public float getERA()
	{
		return era;
	}
	

}
