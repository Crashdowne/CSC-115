
public class LabSequence {

	public static void main(String[] args)
	{
		printSequence(3);
	}
	
	public static void printSequence(int n)
	{
		if(n==1)
		{
			System.out.print(n);
		}
		
		else
		{
			printSequence(n-1);
			System.out.print(n);
			printSequence(n-1);
			
		}
	}
}
