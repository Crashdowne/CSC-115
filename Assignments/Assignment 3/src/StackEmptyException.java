//
// StackEmptyException.java
//
// For this assignment we have decided to make the 
// exception checked so that the exception handling
// mechanisms are explicit.
// 
public class StackEmptyException extends Exception
{
	public StackEmptyException(String msg)
	{
		super(msg);
	}
}

