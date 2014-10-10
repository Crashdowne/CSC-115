
public class SquenceOfDigits {

	public static void main(String[] args)
	{
		System.out.println(squenceOfDigits(111));
	}
	
	public static int squenceOfDigits(int n)
	{
		if(n / 10 == 0)
		{
			return 0;
		}
		
		else
		{
			int x= n % 10;
			n = n/10;
			return squenceOfDigits(n);
		}
		
	}
	
}
