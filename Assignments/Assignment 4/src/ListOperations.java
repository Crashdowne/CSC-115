/*
 * List Operations
 * Bryan Kesteloo
 * V00178963
 * 
 */
import java.util.*;

public class ListOperations{

	// prints a list of type T to the console with a newline 
	// after each element
	// precondtion:  type T implements the toString() method
	public static <T> void printList(List<T> l){
	
		ListIterator<T> i = l.listIterator();

		String s = "";	
		while (i.hasNext()) 
          	s+=(i.next()+ "\n");
       
       	System.out.println(s);
	}
	
	// sorts a list of type T where T is type that extends 
	// the Comparable<T> interface
	// and therefore implements the compareTo(T o) method
	// uses the selection sort algorithm 
	// with the get(int index) method of List
	public static <T extends Comparable<? super T>> void selectionSort(List<T> list){
        T temp;
    	int pos;
    	int n = list.size();
		for (int i=0; i<n-1; i++) {
			pos = i;
			for (int j=i+1; j<n; j++) {
				if(list.get(j).compareTo(list.get(pos)) < 0) {
					pos = j;
				}
			}
			if(pos != i){
				temp = list.get(i);
				list.set(i, list.get(pos));
				list.set(pos, temp);
	     	}
		}
	}
	
	// sorts a list of type T where T is type that extends 
	// the Comparable<T> interface
	// and therefore implements the compareTo(T o) method
	// uses the bubblesort algorithm 
	// with the get(int index) method of List
	public static <T extends Comparable<? super T>> void bubbleSort(List<T> list)
	{
		T temp;
		// Gets the size of the list to sort
		int n = list.size();
		// Performs sort
		for(int i=0; i<n-1; i++)
		{
			// Goes through the list and compares each value, performed a swap if necessary
			for(int j=0; j<n-1; j++)
			{
				if(list.get(j).compareTo(list.get(j+1)) > 0)
				{
					temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);			
				}
			}
		}
	}

	// sorts a list of type T where T is type that extends 
	// the Comparable<T> interface
	// and therefore implements the compareTo(T o) method
	// uses the bubblesort algorithm 
	// with the listIterator() method of List
	public static <T extends Comparable<? super T>> void bubbleSortI(List<T> list)
	{
		// Uses an iterator to perform BubbleSort
		if(list.size() > 0)
			{
				for(int i=0; i<list.size()-1; i++)
				{
					// Creates a new iterator each run through
					ListIterator<T> itr = list.listIterator();
					// Sets the initial index to 0
					int previousIndex = itr.nextIndex();
					// Gets the value at index 0
					T previousValue = itr.next();
					while(itr.hasNext())
					{
						// Gets the next index in the list
						int valueIndex = itr.nextIndex();
						// Gets the value at that index
						T value = itr.next();
						// Compares the two values and performs swap if necessary
						if(previousValue.compareTo(value) > 0)
						{
							// Swap in list
							Swap(list, previousIndex, valueIndex);
						
							// Swap in tracking values
							T temp = value;
							value = previousValue;
							previousValue = temp;
						}
					previousIndex = valueIndex;
					previousValue = value;
				}
			}
		}
	}
	// sorts a list of type T where T is type that extends 
	// the Comparable<T> interface
	// and therefore implements the compareTo(T o) method
	// uses the quicksort algorithm 
	// with the get(int index) method of List
	public static <T extends Comparable<? super T>> void quicksort(List<T> list){
		quickSort(list, 0, list.size()-1);
	}
	
	// private helper method that can be used to implement quicksort recursively
	private static <T extends Comparable<? super T>> void quickSort(List<T> list, int low, int high)
	{
		// Selects the index for the pivot
		int middle = ((low+high)/2);
		// Gets the value for the Pivot
		T pivot = list.get(middle);
		// Sets the indices for the high and low values
		int i = low;
		int j = high;
		// Loops until the two indices meet
		while(i<=j)
		{
			// Increment i until it has a value that is greater than the Pivot
			while(list.get(i).compareTo(pivot) < 0)
			{
				i++;
			}
			// Decrements j until it has a value less than the Pivot
			while(list.get(j).compareTo(pivot) > 0)
			{
				j--;
			}
			// Performs a swap if necessary
			if(i <= j)
			{
				// Calls the Swap method
				Swap(list, i, j);
				i++;
				j--;	
			}
		}
		// Calls quickSort with the smaller left side of the list
		if(low < j)
		{
			quickSort(list, low, j);
		}
		// Calls quickSort with the smaller right side of the list
		if(i < high)
		{
			quickSort(list, i, high);
		}
	}
	
	// Swap method
	public static <T extends Comparable<? super T>> void Swap(List<T> list, int index1, int index2)
	{
		T temp = list.get(index2);
		list.set(index2, list.get(index1));
		list.set(index1, temp);
	}

	// sequentially searches a list of type T for element e of type T 
	// where T is a type that extends the Comparable<T> interface and
	// therefore implements the compareTo(T o) method
	// This method uses the get(int index) method of List
	// 
	// if found returns the position at which e is stored, else returns -1
	public static <T extends Comparable<? super T>> int seqSearch(List<T> list, T e)
	{
		int n = list.size();
		int index = 0;
		// Sets up a boolean to report if the value is found in the list
		boolean exists = false;
		// Searches for the value
		for(int i = 0; i<n; i++)
		{
			// Gets a value to compare from the list at the index
			T value = list.get(i);
			// Returns true if the value is in the list
			if(value.equals(e))
			{
				exists = true;
				break;
			}
			// Returns false if the value is not found in the list
			else
			{
				exists = false;
			}
			index++;
		}
		// Returns the index of where the value was in the list, if it was found
		if(exists)
		{
			return index;
		}
		// Returns -1 to say that the value was not found in the list
		else
		{
			return -1;
		}
	}
	
	// sequentially searches a list of type T for element e of type T 
	// where T is a type that extends the Comparable<T> interface and 
	// therefore implements the compareTo(T o) method
	// This method uses iterators from  List
	// 
	// if found returns the position at which e is stored, else returns -1
	public static <T extends Comparable<? super T>> int seqSearchI(List<T> list, T e)
	{
		// Sets up an iterator for the search
		ListIterator<T> itr = list.listIterator();
		int index = 0;
		boolean match = false;
		// Iterator moves along the list
		while(itr.hasNext())
		{
			T value = itr.next();
			// Compares the two values, returns true if it is found
			if(value.equals(e))
			{
				match = true;
				break;
			}
			// Returns false if the value is not found
			else
			{
				match = false;
			}
			index = itr.nextIndex();
		}
		// Returns the index of the value, if it was found
		if(match == true)
		{
			return index;
		}
		// Says that the value was not in the list
		else
		{
			return -1;
		}
	}
	
	// searches a list of type T for element e of type T where T is  
	// a type that extends the Comparable<T> interface and therefore 
	// implements the compareTo(T o) method using the binary search method
	//
	// precondtion:  list is in sorted order
	// 
	// if found returns the position at which e is stored, else returns -1
	public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T e)
	{
		// Calls the binarySearch method by passing it the necessary variables
		int index = binarySearch(list, e, 0, list.size()-1);
		// Returns the index of the value returned from the search
		return index;
	}
	
	// private helper method that can be used to implement binary search recursively
	private static <T extends Comparable<? super T>> int binarySearch(List<T> list, T e, int left, int right)
	{
		// Chooses the index for the middle value
		int mid = (left + right) /2;
		// Gets the value at the middle
		T middle = list.get(mid);
		// Returns the index is the value is found in the list
		if(middle.equals(e))
		{
			return mid;
		}
		// Says the value was not in the list
		if(left == right)
		{
			return -1;
		}		
		// If the middle value is greater than the value, moves the mid to the left
		if(e.compareTo(middle) < 0)
		{
			right = mid - 1;
		}
		// If the middle value is less than the value, moves the mid to the right
		else if(e.compareTo(middle) > 0)
		{
			left = mid + 1;
		}
		return binarySearch(list, e, left, right);
	}
}