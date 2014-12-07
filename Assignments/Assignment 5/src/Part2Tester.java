import java.util.*;

public class Part2Tester
{
	public static int  	testCount = 0;
	public static boolean  	testHeapSolution = true;

	public static void displayResults (boolean passed)
	{
		/* There is some magic going on here getting the line number 
		 * Borrowed from:
		 * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/	 
		*/
		if (passed)
		{
			System.out.println ("Passed test: " + testCount);
		}
		else
		{
			System.out.println ("Failed test: " + testCount + " at line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
			System.exit(1);
		}
		testCount++;
	}

	
	public static void testOne ()
	{
		System.out.println("Testing Patient creation.");
		Patient p1 = new Patient(3, "Lady Gaga", 123, "torn voice box" );
		Patient p2 = new Patient(8, "Keith Richards", 456, "failing liver" );
		Patient p3 = new Patient(3, "Taylor Swift", 789, "broken heart" );
		Patient p4 = new Patient(5, "T. Swift", 789, "broken nose" );
		
		displayResults(p1.compareTo(p2) < 0);
		displayResults(p2.compareTo(p1) > 0); 
		displayResults(p1.compareTo(p1) == 0); 	
		displayResults(p3.equals(p4));	

	}

	public static void addArray (int[] a, PriorityQueue q)
	{
		for (int i=0;i<a.length;i++)
		{
			q.insert(a[i]);
		}
	}

	public static void testTwo()
	{

		System.out.println("Testing adding/removing patients.");
		Patient p1 = new Patient(3, "Lady Gaga", 123, "torn voice box" );
		Patient p2 = new Patient(8, "Keith Richards", 456, "failing liver" );
		Patient p3 = new Patient(2, "Taylor Swift", 789, "broken heart" );
		Patient p4 = new Patient(7, "Kevin Bacon", 356, "too many movies" );
		Patient p5 = new Patient(6, "Tom Cruise", 321, "depression" );
		Patient p6 = new Patient(10, "Mick Jagger", 678, "heart attack" );
		
		Triage er = new Triage();
		displayResults(er.numPatientsWaiting() == 0);
		
		er.addPatient(p1);
		er.addPatient(p2);
		er.addPatient(p3);
		er.addPatient(p4);
		er.addPatient(p5);
		
		displayResults(er.numPatientsWaiting() == 5);
				
		displayResults(p2.equals(er.nextPatient()));
		er.addPatient(p6);
		displayResults(er.numPatientsWaiting() == 5);
		
		displayResults(p6.equals(er.nextPatient()));
		displayResults(p4.equals(er.nextPatient()));				
		displayResults(er.numPatientsWaiting() == 3);
		
		displayResults(p5.equals(er.nextPatient()));	
		displayResults(p1.equals(er.nextPatient()));
		displayResults(p3.equals(er.nextPatient()));	
		displayResults(er.numPatientsWaiting() == 0);
		
	}
	

	public static void main (String[] args)
	{

		System.out.println("Testing Assignment 5 - Part2.");
		testOne();
		testTwo();

	}
}
