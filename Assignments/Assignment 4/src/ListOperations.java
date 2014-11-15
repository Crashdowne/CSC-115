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
		int n = list.size();
		
		for(int i=0; i<n-1; i++)
		{
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
		if(list.size() > 0)
			{
				for(int i=0; i<list.size()-1; i++)
				{
					// Creates a new iterator each run through
					ListIterator<T> itr = list.listIterator();
					// Sets the initial index to 0
					int previousIndex = itr.nextIndex();
					T previousValue = itr.next();
				
					while(itr.hasNext())
					{
						int valueIndex = itr.nextIndex();
						T value = itr.next();
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

		int middle = ((low+high)/2);
		T pivot = list.get(middle);
		int i = low;
		int j = high;
		
		while(i<=j)
		{
			
			while(list.get(i).compareTo(pivot) < 0)
			{
				i++;
			}
			
			while(list.get(j).compareTo(pivot) > 0)
			{
				j--;
			}
			
			if(i <= j)
			{
				Swap(list, i, j);
				i++;
				j--;	
			}
		}
		
		if(low < j)
		{
			quickSort(list, low, j);
		}
		
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
	public static <T extends Comparable<? super T>> int seqSearch(List<T> list, T e){
		
		int n = list.size();
		int index = 0;
		boolean exists = false;
		
		for(int i = 0; i<n; i++)
		{
			T value = list.get(i);
			
			if(value.equals(e))
			{
				exists = true;
				break;
			}
			
			else
			{
				exists = false;
			}
			index++;
		}
		
		if(exists)
		{
			return index;
		}
		
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
	public static <T extends Comparable<? super T>> int seqSearchI(List<T> list, T e){

		ListIterator<T> itr = list.listIterator();
		int index = 0;
		boolean match = false;
		
		while(itr.hasNext())
		{
			T value = itr.next();
			
			if(value.equals(e))
			{
				match = true;
				break;
			}
			
			else
			{
				match = false;
			}
			index = itr.nextIndex();
		}
		
		if(match == true)
		{
			return index;
		}
		
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
	public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T e){
		
		int index = binarySearch(list, e, 0, list.size()-1);
		
		return index;
	}
	
	// private helper method that can be used to implement binary search recursively
	private static <T extends Comparable<? super T>> int binarySearch(List<T> list, T e, int left, int right){
		
		int mid = (left + right) /2;
		T middle = list.get(mid);
		
		if(middle.equals(e))
		{
			return mid;
		}
		
		if(left == right)
		{
			return -1;
		}		
		
		if(e.compareTo(middle) < 0)
		{
			right = mid - 1;
		}
		
		else if(e.compareTo(middle) > 0)
		{
			left = mid + 1;
		}
		
		return binarySearch(list, e, left, right);
	}
}