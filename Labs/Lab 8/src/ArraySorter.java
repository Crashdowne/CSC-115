public class ArraySorter{

   public static void main(String [] args){
      ArraySorter mySorter = new ArraySorter();
      int size = 12;
      
      //Selection Sort
      int[] array = mySorter.createArray(size);
      System.out.print("\nUnsorted Random Array: ");
	  mySorter.printArray(array);
      mySorter.selectionSort(array);
      System.out.print("After selection sort: ");
      mySorter.printArray(array);	
		
      //Bubble Sort
      array = mySorter.createArray(size);
      System.out.print("\nUnsorted Random Array: ");
	  mySorter.printArray(array);
      mySorter.bubbleSort(array);
      System.out.print("After bubble sort: ");
      mySorter.printArray(array);	

      //Quick Sort
      array = mySorter.createArray(size);
      System.out.print("\nUnsorted Random Array: ");
	  mySorter.printArray(array);
      mySorter.quickSort(array, 0, array.length-1);
      System.out.print("After quick sort: ");
      mySorter.printArray(array);
      
      //Merge Sort
      array = mySorter.createArray(size);
      System.out.print("\nUnsorted Random Array: ");
	  mySorter.printArray(array);
      mySorter.mergeSort(array);
      System.out.print("After merge sort: ");
      mySorter.printArray(array);
   }
	
	
	/*
      1. Find the minimum value in the list
      2. Swap it with the value in the first position
      3. Repeat the steps above for the remainder of the list 
	  	(starting at the second position and advancing each time)
	*/
	public void selectionSort(int [] array) {
      
		for(int round=1; round<array.length; round++)
		{
			//round-1 because round = 1, so sets to the value at array[0]
			int min = round-1;
			//don't have to loop the entire array because it is placing things in the correct spot each round
			for(int i=round; i<array.length; i++)
			{
				if(array[i] < array[min])
				{
					min = i;
				}
			}
			if(min != (round-1))
			{
				int temp = array[round -1];
				array[round-1] = array[min];
				array[min] = temp;
			}
		}
	}
	

	public void bubbleSort(int [] array) {
	   //Implements bubble sort
		int count = 0;
		boolean isSorted = false;
		
		for(int i=1; i<array.length; i++)
		{
			for(int j=0; j<array.length-i; j++)
			{
				if(array[j] > array[j+1])
				{
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
					isSorted = false;
				}
				else
				{
					isSorted = true;
				}
			}
			count ++;
			if(isSorted == true)
			{
				break;
			}
		}
		System.out.println("Number of rounds: " + count);
	}


	/*
      1. Pick an element, called a pivot, from the list.
      2. Reorder the list so that all elements with values
         less than the pivot come before the pivot, while all elements
         with values greater than the pivot come after it
         (equal values can go either way). After this partitioning, 
         the pivot is in its final position. This is called the partition operation.
      3. Recursively sort the sub-list of lesser elements and the sub-list of greater elements.
	*/
	public void  quickSort(int [] array, int lo, int hi)
	{
		int i = lo;
		int j = hi;
		int middle = (lo+hi)/2; //guess at pivot index
		int pivot = array[middle];
		
		while(i<=j)
		{
			while(array[i] < pivot)
			{
				i++;
			}
			
			while(array[j] > pivot)
			{
				j--;
			}
			
			if(i <= j)
			{
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				
				i++;
				j--;
			}
		}
		
		if(lo < j)
		{
			quickSort(array, lo, j);
		}
		
		if(i < hi)
		{
			quickSort(array, i, hi);
		}
	}
		
	
	/*
      1. If the list is of length 0 or 1, then it is already sorted. 
         Otherwise: Divide the unsorted list into two sublists of about half the size.
      2. Sort each sublist recursively by re-applying the merge sort.
      3. Merge the two sublists back into one sorted list.
	*/
	public void mergeSort(int [] array){
		//Implements merge sort
	}


	/*
      Prints out the contents of a given array
	*/
	public void printArray(int [] array){
       for(int i=0; i<array.length; i++)
          System.out.print(array[i] + " ");
       System.out.println();
	}
	
	
	/*
      Creates an array of random numbers
	*/
	public int [] createArray(int size){
	    java.util.Random rand = new java.util.Random();
		int [] tempArray = new int [size];
		for(int i=0; i<size; i++)
		   tempArray[i] = rand.nextInt(1000);
		return tempArray;
	}
}