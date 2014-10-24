
public class LLStack<T> implements Stack<T>
{
	private int count;
	private T top = null;
	private T bottom = null;
	
	public int size()
	{
		return this.count;
	}
	
	public boolean empty()
	{
		if (this.count == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void makeEmpty()
	{
		this.top = this.bottom;
	}
	
	public void push(T node)
	{
		
	}

}
