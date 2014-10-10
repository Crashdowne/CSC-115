public class RecursiveLog{
   public static int calculateRecursiveLog (long n, int base){
      return 0;
   }
   public static void main(String[] args){
      long n = 1024;
	  int base = 2;
      System.out.println("log " + n + " base " + base + " = " + calculateRecursiveLog(n, base));
	  
	  base = 10;
	  System.out.println("log " + n + " base " + base + " = " + calculateRecursiveLog(n, base));
   }
}