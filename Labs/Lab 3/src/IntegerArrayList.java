
public class IntegerArrayList implements IntegerList {
	
	private IntegerList[] integerList;
	private int count;
	
	public IntegerArrayList ()
	{
		this.integerList = new IntegerList[5];
		this.count = 0;
	}

	public void addFront ()
	{
		IntegerList[] intList2 = new IntegerList[integerList.length+1];
		intList2 [0] = value;
		for (int i = 1; i<intList2.length; i++)
		{
			intList2 [i] = integerList [i];
		}
		count ++;
		integerList = intList2;
		
	}
	
	public void addBack (IntegerList value)
	{
		IntegerList[] intList2 = new IntegerList[integerList.length+1];

		for (int i = 0; i<intList2.length; i++)
		{
			intList2 [i] = integerList [i];
		}
		intList2 [integerList.length+1] = value;
		count ++;
		integerList = intList2;
	}
	
	public int size ()
	{
		return size();
	}

	public int get (int pos)
	{
		int position = integerList[pos]
		return position;
	}
	
	public void clear ()
	{
		
	}
	
	public void remove ()
	{
		
	}
	
	public String toString ()
	{
		return "";
	}

}
