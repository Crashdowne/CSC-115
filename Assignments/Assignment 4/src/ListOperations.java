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
	public static <T extends Comparable<? super T>> void bubbleSort(List<T> list){

	}

	// sorts a list of type T where T is type that extends 
	// the Comparable<T> interface
	// and therefore implements the compareTo(T o) method
	// uses the bubblesort algorithm 
	// with the listIterator() method of List
	public static <T extends Comparable<? super T>> void bubbleSortI(List<T> list){

		
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
	private static <T extends Comparable<? super T>> void quickSort(List<T> list, int lo, int hi){

	}

	// sequentially searches a list of type T for element e of type T 
	// where T is a type that extends the Comparable<T> interface and
	// therefore implements the compareTo(T o) method
	// This method uses the get(int index) method of List
	// 
	// if found returns the position at which e is stored, else returns -1
	public static <T extends Comparable<? super T>> int seqSearch(List<T> list, T e){
		
		return -1;
	
	}
	
	// sequentially searches a list of type T for element e of type T 
	// where T is a type that extends the Comparable<T> interface and 
	// therefore implements the compareTo(T o) method
	// This method uses iterators from  List
	// 
	// if found returns the position at which e is stored, else returns -1
	public static <T extends Comparable<? super T>> int seqSearchI(List<T> list, T e){

		return -1;
	}
	
	// searches a list of type T for element e of type T where T is  
	// a type that extends the Comparable<T> interface and therefore 
	// implements the compareTo(T o) method using the binary search method
	//
	// precondtion:  list is in sorted order
	// 
	// if found returns the position at which e is stored, else returns -1
	public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T e){
		
		return -1;
	}
	
	// private helper method that can be used to implement binary search recursively
	private static <T extends Comparable<? super T>> int binarySearch(List<T> list, T e, int left, int right){
		return -1;
	}
	


}