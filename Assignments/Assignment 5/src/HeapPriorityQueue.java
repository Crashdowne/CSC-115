/*
 * HeapPriorityQueue.java
 *
 * An implementation of a PriorityQueue using a heap.
 * based on the implementation in "Data Structures and Algorithms
 * in Java", by Goodrich and Tamassia
 *
 * This implementation will throw a Runtime, HeapEmptyException 
 *	if the heap is empty and removeHigh is called.
 *
 * This implementation will throw a Runtime, HeapFullException 
 *	if the heap is full and insert is called.
 * 
 */
 
public class HeapPriorityQueue implements PriorityQueue 
{
	protected final static int DEFAULT_SIZE = 10000;
	
	protected Comparable[] storage;
	protected int currentSize;
			
	public HeapPriorityQueue () 
	{
		this(DEFAULT_SIZE);
	}

	public HeapPriorityQueue(int size)
	{
		storage = new Comparable[size];
		currentSize = 0;
	}
	
	public int size ()
	{
		return currentSize;
	}
	
	public boolean isEmpty ( )
	{
		return currentSize == 0;
	}

	public boolean isFull ( )
	{
		return currentSize == storage.length;
	}
	
	public Comparable removeHigh () throws HeapEmptyException
	{			
		
		// Step 1 insert last element in the array into the top of the array
		// Step 2 remove the last element of the array (set it to null?)
		// Decrease the size of the array
		// Bubble the value down

		Comparable valueToBeReturned;
		if (this.isEmpty())
		{
			throw new HeapEmptyException();
		}
		
		else
		{
			int lastIndex = currentSize-1;
			swapElement (0, lastIndex);
			valueToBeReturned = storage[lastIndex];
			storage[lastIndex] = null;
			currentSize--;
			bubbleDown(0);
		}
		return valueToBeReturned;
	}

	public void insert ( Comparable k  ) throws HeapFullException //6
	{	
		// if no elements, insert to root (pos 0) --->Done
		// error if heap is full (heapfullexception) --->Done
		// insert at end of array
		// call bubble up on index
				
		if (isEmpty())
		{
			storage[0] = k;
			currentSize++;
			return;
		}
		else if (isFull())
		{
			throw new HeapFullException();
		}
		else
		{
			int newIndex = currentSize;
			storage[newIndex] = k;
			bubbleUp(newIndex);
			currentSize++;
		}
	}
		
	protected void bubbleUp ( int childIndex ) //4
	{
		//compare parents until root
		//swap if greater
		// if child index is root then done
		if (childIndex != 0)
		{
			int parentIndex = parent(childIndex);
			Comparable child = storage[childIndex];
			Comparable parent =  storage[parentIndex];
			
			if (child.compareTo(parent) > 0)
			{
				swapElement (childIndex, parentIndex);
			}
			bubbleUp(parentIndex);
		}
	}

	protected void bubbleDown(int parentIndex) //5
	{
		// Is there a child on the right?
		// Is the parent larger than the right?
		// 		if yes, don't do anything
		//		if no, swap parent and right child
		
		if (hasRight(parentIndex))
		{
			if (storage[parentIndex].compareTo(storage[rightChild(parentIndex)]) <0)
			{
				swapElement (parentIndex, rightChild((parentIndex)));
				bubbleDown(rightChild((parentIndex)));
			}	
		}
		
		else if (hasLeft(parentIndex))
		{
			if (storage[parentIndex].compareTo(storage[leftChild(parentIndex)]) <0)
			{
				swapElement (parentIndex, leftChild((parentIndex)));
				bubbleDown(leftChild((parentIndex)));
			}
		}
	}	
	
	protected void swapElement ( int p1, int p2 ) //3
	{
		//bounds checking
		Comparable placeHolder;
		placeHolder = storage[p1];
		storage[p1] = storage[p2];
		storage[p2] = placeHolder;
	}
	
	protected int parent ( int pos )
	{
		return ((pos-1)/2);
	}
	
	protected int leftChild ( int pos )
	{
		// check if out of bounds
			return (2*pos)+1;
	}
	
	protected int rightChild ( int pos )
	{	
		// check if out of bounds
			return (pos*2)+2;
	}
	
	protected boolean hasLeft ( int pos ) //1
	{
		// what if leftChild(pos) is out of bounds?? compare with size first :)
		if(storage[leftChild(pos)] != null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	protected boolean hasRight ( int pos ) //2
	{
		// what if rightChild(pos) is out of bounds?? compare with size first :)
		if(storage[rightChild(pos)] != null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	private boolean VerifyInBounds(int index)
	{
		return false;
	}
}
