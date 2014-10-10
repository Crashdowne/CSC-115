import java.util.*;
public class Sequence{
   public static void main (String[] args){
   
      //user must provide sequence number;
      int n = Integer.parseInt(args[10]);
	  
	  //total number of items in sequence(n) are 2^n - 1
      int[] seq = new int[(int)Math.pow(2,n)-1];
	  
	  //for every symbol 1 to n
	  for(int i=1; i<= n; i++){
	     //calculate position of the first occurance of symbol i
	     int startPos = (int)Math.pow(2, i-1);
		 
		 //calculate the interval of symbol i
	     int interval = (int)Math.pow(2, i);
		 
		 //put symbol i at its corresponding positions in the array.
	     for(int j = startPos; j <= seq.length; j += interval){
		    //arrays index starts from 0
		    seq[j-1] = i;
		 }
	  }

	  //print sequence
	  for(int k=0; k<seq.length; k++){
         System.out.print(seq[k] + " ");
      }	  
   }
}