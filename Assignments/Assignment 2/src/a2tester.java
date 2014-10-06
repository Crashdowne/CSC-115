/*
 * a2tester.java
 *
 * A test program for assignment 2.
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
public class a2tester
{
	public static int  	testCount = 0;
	public static boolean  	testArraySolution = false; // change this value to false to test your linked-list implementation
	public static int 	stressTestSize = 20000;


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
		boolean 	passed;
		PlayerList 	l = createNewList();
		
		System.out.println("Basic testing of toString, size, addAt");
		displayResults (l.size() == 0);
		displayResults (l.toString().equals("{}"));
		
		Player p1 = new Player("first");
		Player p2 = new Player("second");
		Player p3 = new Player("third");
		Player p4 = new Player("fourth");
		
		l.addAt(p1,0);
		displayResults (l.size() == 1);
		//System.out.println(l);
		displayResults (l.toString().equals("{first:0}"));

		l.addAt(p2,0);
		displayResults (l.size() == 2);
		//System.out.println(l);
		displayResults (l.toString().equals("{second:0,first:0}"));		

		l.addAt(p3,1);
		displayResults (l.size() == 3);
		//System.out.println(l);
		displayResults (l.toString().equals("{second:0,third:0,first:0}"));	
		
		l.addAt(p4,1);	
		displayResults (l.size() == 4);
		//System.out.println(l);
		displayResults (l.toString().equals("{second:0,fourth:0,third:0,first:0}"));		

	}


	public static void testTwo()
	{
	
		System.out.println("Basic testing of addAt, get");
		PlayerList 	l = createNewList();
		
		Player p1 = new Player("first");
		Player p2 = new Player("second");
		Player p3 = new Player("third");
		Player p4 = new Player("fourth");		
		
		System.out.println("Basic testing of size, addAt, get");
		l.addAt(p1,0);
		l.addAt(p2,0);
		l.addAt(p3,1);	
		l.addAt(p4,1);	
		
		//System.out.println(l);
		
		displayResults (l.size() == 4);
		displayResults (l.toString().equals("{second:0,fourth:0,third:0,first:0}"));
		
		displayResults (l.get(0).equals(p2));

		displayResults (l.get(1).equals(p4));

		displayResults (l.get(2).equals(p3));

		displayResults (l.get(3).equals(p1));
	
	}

	public static void testThree()
	{
	
		System.out.println("Basic testing of append, get");
		PlayerList 	l = createNewList();
		
		Player p1 = new Player("first");
		Player p2 = new Player("second");
		Player p3 = new Player("third");
		Player p4 = new Player("fourth");	
		Player p5 = new Player("fifth");	
		Player p6 = new Player("sixth");		

		l.append(p1);
		l.append(p2);
		l.append(p3);	

		//System.out.println(l);
		
		displayResults (l.size() == 3);
		displayResults (l.toString().equals("{first:0,second:0,third:0}"));
		
		displayResults (l.get(0).equals(p1));

		displayResults (l.get(1).equals(p2));

		displayResults (l.get(2).equals(p3));

		l.addAt(p4,2);
		l.append(p5);
		l.addAt(p6,4);	
		//System.out.println(l);
		
		displayResults (l.size() == 6);
		displayResults (l.toString().equals("{first:0,second:0,fourth:0,third:0,sixth:0,fifth:0}"));
		
		displayResults (l.get(0).equals(p1));
		displayResults (l.get(1).equals(p2));
		displayResults (l.get(2).equals(p4));
		displayResults (l.get(3).equals(p3));
		displayResults (l.get(4).equals(p6));
		displayResults (l.get(5).equals(p5));
	}

	public static void testFour()
	{
	
		System.out.println("Basic testing of find, get");
		PlayerList 	l = createNewList();
		
		Player p1 = new Player("first");
		Player p2 = new Player("second");
		Player p3 = new Player("third");
		Player p4 = new Player("fourth");	
		Player p5 = new Player("fifth");	
		Player p6 = new Player("second", 500); // p1 and p6 are equal but not same bAvg
		Player p7 = new Player("sixth"); // p1 and p6 are equal but not same bAvg

		l.append(p1);
		l.append(p2);
		l.append(p3);
		l.addAt(p4,0);	
		l.addAt(p5,0);	
		l.addAt(p6,0);	
		l.addAt(p7,0);	
				
		displayResults (l.size() == 7);		
		
		Player pf = new Player("fourth");		
		int found = l.find(pf);
		//System.out.println(found);
		displayResults (found != -1);
		displayResults (l.size() == 7);	
		displayResults (l.get(found).equals(p4));	
		
		displayResults (l.get(0).equals(p7));
		displayResults (l.get(1).equals(p6));
		displayResults (l.get(2).equals(p5));
		displayResults (l.get(3).equals(p4));
		displayResults (l.get(4).equals(p1));
		displayResults (l.get(5).equals(p2));
		displayResults (l.get(6).equals(p3));
		
		Player pmultiple = new Player("second");		
		found = l.find(pmultiple);
		//System.out.println(found);
		
		displayResults (found != -1);
		displayResults (found == 1);
		displayResults (l.get(found).equals(p6));		
		displayResults ((l.get(found)).getBattingAvg() == 500);		


		Player pn = new Player("zero");
		found = l.find(pn);
		
		//System.out.println(found);
		displayResults (found == -1);
		
	}

	public static void testFive()
	{	
		System.out.println("Basic testing of clear");
		
		PlayerList 	l = createNewList();
		
		Player p1 = new Player("first");
		Player p2 = new Player("second");
		Player p3 = new Player("third");
		Player p4 = new Player("fourth");	
		Player p5 = new Player("fifth");	
		Player p6 = new Player("first", 500); // p1 and p6 are equal but not same bAvg

		l.append(p1);
		l.addAt(p2,0);
		l.append(p3);
		l.addAt(p4,0);	
		l.addAt(p5,3);	
		l.addAt(p6,0);	
		
		displayResults (l.size() == 6);	
		//System.out.println(l);
		displayResults (l.toString().equals("{first:500,fourth:0,second:0,first:0,fifth:0,third:0}"));

		l.clear();
		
		displayResults (l.size() == 0);	
		//System.out.println(l);
		displayResults (l.toString().equals("{}"));
	}

	public static void testSix()
	{	
		System.out.println("Basic testing of removeAt");	
		
		PlayerList 	l = createNewList();
		
		Player p1 = new Player("first");
		Player p2 = new Player("second");
		Player p3 = new Player("third");
		Player p4 = new Player("fourth");	
		Player p5 = new Player("fifth");	
		Player p6 = new Player("sixth"); // p1 and p6 are equal but not same bAvg

		l.append(p1);
		l.append(p2);
		l.append(p3);	
		l.append(p4);	
		l.append(p5);
		l.append(p6);	
		
		displayResults (l.size() == 6);	
		
		l.removeAt(2);
		//System.out.println(l);
		displayResults (l.size() == 5);	
		displayResults (l.toString().equals("{first:0,second:0,fourth:0,fifth:0,sixth:0}"));
		
		l.removeAt(4);
		//System.out.println(l);
		displayResults (l.size() == 4);	
		displayResults (l.toString().equals("{first:0,second:0,fourth:0,fifth:0}"));	
		
		l.removeAt(0);
		//System.out.println(l);
		displayResults (l.size() == 3);	
		displayResults (l.toString().equals("{second:0,fourth:0,fifth:0}"));
			
		
		displayResults (l.get(0).equals(p2));
		displayResults (l.get(1).equals(p4));
		displayResults (l.get(2).equals(p5));
	}
		
	public static void testSeven()
	{	
	
		System.out.println("Basic testing of remove");	
		
		PlayerList 	l = createNewList();
		
		Player p1 = new Player("first");
		Player p2 = new Player("second");
		Player p3 = new Player("third");
		Player p4 = new Player("first");	
		Player p5 = new Player("first");	
		Player p6 = new Player("sixth"); // p1 and p6 are equal but not same bAvg

		l.append(p1);
		l.append(p2);
		l.append(p3);	
		l.append(p4);	
		l.append(p5);
		l.append(p6);	
		
		displayResults (l.toString().equals("{first:0,second:0,third:0,first:0,first:0,sixth:0}"));
		Player pfound = new Player("second");
		l.remove(pfound);
		displayResults (l.size() == 5);	
		//System.out.println(l);
		displayResults (l.toString().equals("{first:0,third:0,first:0,first:0,sixth:0}"));
		
		
		Player notfound = new Player("tenth");
		l.remove(notfound);
		displayResults (l.size() == 5);	
		//System.out.println(l);
		displayResults (l.toString().equals("{first:0,third:0,first:0,first:0,sixth:0}"));
		
		Player multiple = new Player("first");
		l.remove(multiple);
		displayResults (l.size() == 2);	
		//System.out.println(l);
		displayResults (l.toString().equals("{third:0,sixth:0}"));
		
		displayResults (l.get(0).equals(p3));
		displayResults (l.get(1).equals(p6));
	}
	
	public static void testEight()
	{		
		PlayerList 	l1 = createNewList();

		System.out.println("Stress test.");

		for (int i=0;i<stressTestSize;i++)
		{
			l1.append(new Player(Integer.toString(i)));
			l1.addAt(new Player(Integer.toString(i)), 0);
		}

		displayResults(l1.size() == stressTestSize*2);
		
		/*
		for (int i =0;i<stressTestSize*2;i++)
		{
			System.out.println(i+":" +l1.get(i));
		}
		*/

		for (int i =0;i<stressTestSize;i++)
		{
			if ( !(l1.get(i).equals(new Player(Integer.toString((stressTestSize-1) - i)))) )
			{
				//System.out.println("they are equal");
				//System.out.println(l1.get(i));
				//System.out.println((new Player(Integer.toString((stressTestSize-1) - i))));
				displayResults(false);
			}

			if ( !(l1.get(i+stressTestSize).equals(new Player(Integer.toString(i)))))
			{
				displayResults(false);
			}
		}

		//System.out.println(l1.size());
		for (int i=0;i<stressTestSize/4;i++)
		{
			l1.removeAt(i);
		}
		
		//System.out.println(l1.size());
		//System.out.println((stressTestSize*2-(stressTestSize/4)));
		displayResults(l1.size() == (stressTestSize*2-(stressTestSize/4)));
		
		for (int i=0;i<stressTestSize;i++)
		{
			l1.remove(new Player(Integer.toString(i)));
		}
		displayResults(l1.size() == 0 );
		
	}

	public static PlayerList createNewList()
	{
		if (testArraySolution)
		{
			return new PlayerArrayList();
		}
		else
		{
			return new PlayerLinkedList();
		}
	}

	public static void main (String[] args)
	{
		if (args.length != 0 && args[0].equals("array"))
		{
			testArraySolution=true;
		}

		testOne();
		testTwo();
		testThree();
		testFour();
		testFive();
		testSix();
		testSeven();
		testEight();
	}
}
