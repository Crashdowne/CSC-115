public class SumOfDigits{
	
   public class SequenceOfDigits {
	
	}
public static long recSumOfDigits(long n){
      
	   if(n == 0)
	   {
		   return 0;
	   }
	   
	   if(n == 1)
	   {
		   return 1;
	   }
	   
	   else	   
	   {
		   return n + recSumOfDigits(n-1);
	   }

   }
   public static void main(String[] args){
      long n = 5;
      System.out.println("sum of digits " + n + " = " + recSumOfDigits(n));
      
      
   }
}