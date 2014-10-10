public class RecursivePower{
	
   public static long calculateRecursivePower(int x, int y)
   {
	   if(y == 0)
	   {
		   return 1;
	   }
	   
	   if(y == 1)
	   {
		   return x;
	   }
	   
	   else
	   {
		   return x*calculateRecursivePower(x, y-1);
	   }
	   
   }
   public static void main(String[] args){
      int x = 3;
	  int y = 3;
      System.out.println(x + " power " + y + " = " + calculateRecursivePower(x,y));
   }
}