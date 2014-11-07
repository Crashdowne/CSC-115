/*
 * a4tester.java
 *
 * A test program for assignment 4.
 *
 * While this program includes many test cases, it was still developed in an ad-hoc
 * manner.  In situations where the code under test is required to work correctly
 * at all times, more care would need to be taken to ensure the test cases 
 * provided good code coverage and that all 'edge cases' were, in fact,
 * tested.
 *
 * When your code has failed one of the test cases, you should look at the what the
 * tester is doing prior to failing the test.  Try to determine which of your methods
 * has the bug in it.  Just because the tester is reporting that you failed the result
 * of a particular method (i.e. get) doesn't mean the bug is in the get method.
 */
 
import java.util.*;

public class TesterPart1
{
	public static int  	testCount = 0;
	public static int  	testsPassed = 0;

	public static void displayResults (boolean passed)
	{
		/* There is some magic going on here getting the line number 
		 * Borrowed from:
		 * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
		 *
		 * Once we've discussed Exceptions in more detail this won't be required.		 
		*/
		if (passed)
		{
			System.out.println ("Passed test: " + testCount);
			testsPassed++;
		}
		else
		{
			System.out.println ("Failed test: " + testCount + " at line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
			//System.exit(1);
			
		}
		testCount++;
	}

	
	public static void testBubbleSort1 ()
	{
		System.out.println("Testing bubblesort with get");

		List<Integer> correct = popRandomList(20, 100, 99, true);
		
		List<Integer> al = popRandomList(20, 100, 99, true);
		List<Integer> ll = popRandomList(20, 100, 99, false);
		
		Collections.sort(correct);
	
		ListOperations.bubbleSort(al);
		ListOperations.bubbleSort(ll);
		
		/*
		ListOperations.printList(correct);
		ListOperations.printList(al);
		ListOperations.printList(ll);
		System.out.println(correct.equals(al));
		*/

		displayResults (correct.equals(al));
		displayResults (correct.equals(ll));		
	}

	public static void testBubbleSort2 ()
	{
		System.out.println("Testing bubblesort with iterator");

		List<Integer> correct = popRandomList(20, 100, 99, true);
		
		List<Integer> al = popRandomList(20, 100, 99, true);
		List<Integer> ll = popRandomList(20, 100, 99, false);
		
		Collections.sort(correct);

		ListOperations.bubbleSortI(al);
		ListOperations.bubbleSortI(ll);
		
		/*
		ListOperations.printList(correct);
		ListOperations.printList(al);
		ListOperations.printList(ll);
		System.out.println(correct.equals(al));
		*/

		displayResults (correct.equals(al));
		displayResults (correct.equals(ll));		
	}
	
	public static void testQuickSort ()
	{
		System.out.println("Testing quicksort");

		List<Integer> correct = popRandomList(20, 100, 99, true);
		
		List<Integer> al = popRandomList(20, 100, 99, true);
		List<Integer> ll = popRandomList(20, 100, 99, false);
		
		Collections.sort(correct);

		ListOperations.quicksort(al);
		ListOperations.quicksort(ll);
		
		/*
		ListOperations.printList(correct);
		ListOperations.printList(al);
		ListOperations.printList(ll);
		System.out.println(correct.equals(al));
		*/

		displayResults (correct.equals(al));
		displayResults (correct.equals(ll));		
	}
	
	public static void testSeqSearch1 ()
	{
		System.out.println("Testing sequential search with get");
		Random rand = new Random(20);
		int index = rand.nextInt(19);
		int alRes = -1;
		int llRes = -1;
		
		List<Integer> al = popRandomList(20, 100, 99, true);
		List<Integer> ll = popRandomList(20, 100, 99, false);
		
		Collections.sort(al);
		Collections.sort(ll);
		
		//System.out.println("index chosen: " + index);
		//System.out.println("value at index: " + al.get(index));
		
		alRes = ListOperations.seqSearch(al, (Integer)al.get(index));
		llRes = ListOperations.seqSearch(ll, (Integer)al.get(index));

		displayResults (alRes == index);
		displayResults (llRes == index);		
	}

	public static void testSeqSearch2 ()
	{
		System.out.println("Testing sequential search with iterator");
		Random rand = new Random(20);
		int index = rand.nextInt(19);
		int alRes = -1;
		int llRes = -1;
		
		List<Integer> al = popRandomList(20, 100, 99, true);
		List<Integer> ll = popRandomList(20, 100, 99, false);
		
		Collections.sort(al);
		Collections.sort(ll);
		
		//System.out.println("index chosen: " + index);
		//System.out.println("value at index: " + al.get(index));
		
		alRes = ListOperations.seqSearchI(al, (Integer)al.get(index));
		llRes = ListOperations.seqSearchI(ll, (Integer)al.get(index));

		displayResults (alRes == index);
		displayResults (llRes == index);		
	}

	
	public static void testBinarySearch ()
	{
		System.out.println("Testing binary search with get");
		Random rand = new Random(20);
		int index = rand.nextInt(19);
		int alRes = -1;
		int llRes = -1;
		
		List<Integer> al = popRandomList(20, 100, 99, true);
		List<Integer> ll = popRandomList(20, 100, 99, false);
		
		Collections.sort(al);
		Collections.sort(ll);
		//System.out.println("index chosen: " + index);
		//System.out.println("value at index: " + al.get(index));
		
		alRes = ListOperations.binarySearch(al, (Integer)al.get(index));
		llRes = ListOperations.binarySearch(ll, (Integer)al.get(index));

		displayResults (alRes == index);
		displayResults (llRes == index);		
	}

	
	public static List<Integer> popRandomList(int size, int maxVal, int seed, boolean testArrayList){
	
	    Random rand = new Random(seed);
	    List<Integer> l;
	    
	    if(testArrayList) 
	    	l = new ArrayList<Integer>(size);
	    else
		    l = new LinkedList<Integer>();

		for(int i=0; i<size; i++)
		   l.add(rand.nextInt(maxVal));
		   
		return l;
	}

	public static void main (String[] args)
	{

		testBubbleSort1();
		testBubbleSort2();
		testQuickSort();
		testSeqSearch1();
		testSeqSearch2();
		testBinarySearch();
		
		System.out.println ("Passed this many tests: " + testsPassed);
	}
}
