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
      //Implements selection sort
	}
	
	// Can be made more efficient
	public void bubbleSort(int [] array) {

		// Number of times to run
		for (int j=0; j<array.length-1; j++)
		{
			// Traverse for swaps
			for(int i=0; i<array.length-1; i++)
			   {
				   if (array[i] > array[i+1])
				   {
					   int tmp = array[i+1];
					   array[i+1] = array[i];
					   array[i] = tmp;
					   //swap(array[i], array[i+1], array);
				   }
			   }
		}
			
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
	public void  quickSort(int [] array, int lo, int hi){
		int i = lo;
		int j = hi;
		int h;

		int middle = (lo+hi)/2; //guess at pivot index
		int temp = array[middle]; //pivot value

		// Runs until i and j meet
		while (i <= j)
		{
			// if the value at i is less than the pivot, move i forward
			while (array[i] < temp)
			{
				i++;
			}
			// if j is greater than the pivot, move j backwards
			while (array[j] > temp)
			{
				j--;
			}
			// if the position of i is <= the position of j, swap the values
			// We have iterated i and j as far as possible
			if (i <= j)
			{
				int tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
				i++;
				j--;
			}
		}
		// Recursive call on the lower partition
		if (lo < j)
		{
			quickSort (array, lo, j);
		}
		// Recursive call on the higher partition
		if (i < hi)
		{
			quickSort (array, i, hi);
		}
	}
		
	
	/*
      1. If the list is of length 0 or 1, then it is already sorted. 
         Otherwise: Divide the unsorted list into two sublists of about half the size.
      2. Sort each sublist recursively by re-applying the merge sort.
      3. Merge the two sublists back into one sorted list.
	*/
	public void mergeSort(int [] array)
	{
		int pivot = array.length /2;
		int lo = 0;
		int hi = array.length;
		
		if (array.length == 1)
		{
			//merge ();
		}
		
		else
		{
			if (lo < pivot)
			{
				int[] tmp = new int[pivot];
				for (int i=0; i<pivot; i++)
				{
					tmp[i] = array[i];
				}
				mergeSort (tmp);
			}
			
			else if (hi >= pivot)
			{
				int[] tmp = new int[pivot];
				for (int i=hi; i>=pivot; i--)
				{
					tmp[i] = array[i];
				}
				mergeSort (tmp);
			}
		}
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