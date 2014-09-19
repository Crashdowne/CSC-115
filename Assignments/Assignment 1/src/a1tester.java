/*
 * a1tester.java
 *
 * A test program for assignment 1.
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
 *
 */
public class a1tester
{
	public static int  	testCount = 0;
	public static boolean  	testArraySolution = false;
	public static int 	stressTestSize = 200;


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
			System.out.println ("Failed test: " + testCount + " at line " 
			+ Thread.currentThread().getStackTrace()[2].getLineNumber());
			System.exit(1);
		}
		testCount++;
	}
	
	public static void PlayerTest()
	{
		System.out.println("Player testing.");
		Player p = new Player("Derek Jeter");

		displayResults (p.getName().equals("Derek Jeter"));
		displayResults (p.getBattingAvg() == 0);
		
		Player p2 = new Player("Derek Jeter", 350);
		displayResults (p2.getName().equals("Derek Jeter"));
		displayResults (p2.getBattingAvg() == 350);

		p.setName("Jose Bautista");
		displayResults (p.getName().equals("Jose Bautista"));
		p.setBattingAvg(450);
		displayResults (p.getBattingAvg() == 450);	

		displayResults(p.toString().equals("Jose Bautista:450"));		
		p = new Player("Michael Saunders");
		displayResults(p.toString().equals("Michael Saunders:0"));

		p = new Player("Derek Jeter");
		p2 = new Player("Derek Jeter", 350);
		displayResults(p.equals(p2));
		p.setName("Nelson Cruz");
		displayResults(p.equals(p2) == false);
	}


	public static void PlayerListTestOne()
	{
		System.out.println("PlayerList testing: constructor, size, add, get, find");

		PlayerList l = new PlayerList();
		Player p = new Player("Derek Jeter");

		displayResults(l.size() == 0);
		l.add(p);
		displayResults(l.size() == 1);
		displayResults(l.get(0).equals(p));
		displayResults(l.find(p) != -1);
	}

	public static void PlayerListTestTwo()
	{
		System.out.println("PlayerList testing: add, get, find, remove");
	
		PlayerList l = new PlayerList();
		Player p1 = new Player("Derek Jeter", 350);
		Player p2 = new Player("Jose Bautista", 400);
	
		l.add(p1);
		l.add(p2);
		displayResults(l.size() == 2);
		Player p3 = l.get(0);
		Player remaining;

		if (p3.equals(p1))
		{
			remaining = p2;
		}
		else
		{
			remaining = p1;
		}
		l.remove(0);
		displayResults(l.find(remaining) != -1);
		displayResults(l.size() == 1);
		displayResults(l.get(0).equals(remaining));
	
		l.remove(0);
		displayResults(l.size() == 0);
	}

	public static void PlayerListResizeTest()
	{
		System.out.println("PlayerList testing resizing, add, find");
		PlayerList l = new PlayerList();
		
		int	num = 5500000;
		for (int i = 0; i < 100; i++)
		{
			l.add(new Player(Integer.toString(num+i)));
		}
		displayResults(l.size() == 100);
		
		boolean passed = true;

		for (int i = 99; i >= 0; i--)
		{
			if (l.find(new Player(Integer.toString(num+i))) == -1)
				passed = false;
		}
		displayResults(passed);	
	}

	public static void PlayerListStressTest()
	{
		System.out.println("PlayerList stress test.");
		
		PlayerList l = new PlayerList();
		
		int	num = 5500000;
		for (int i = 0; i < stressTestSize; i++)
		{
			l.add(new Player(Integer.toString(num+i)));
		}
		displayResults(l.size() == stressTestSize);
		
		boolean passed = true;

		for (int i = (stressTestSize - 1); i >= 0; i--)
		{
			if (l.find(new Player(Integer.toString(num+i))) == -1)
				passed = false;
		}
		displayResults(passed);	

		passed = true;
		for (int i = (stressTestSize - 1); i > 0; i--)
		{
			Player p = l.get(0);
			l.remove(0);

			if (l.find(p) != -1)
			{
				passed = false;
				break;
			}

			if (l.size() != i)
			{
				passed = false;	
				break;	
			}
		}
		displayResults(passed);
		
	}

	public static void TeamTest()
	{
		System.out.println("Testing Team");
		Player p1 = new Player("Derek Jeter", 350);
		Player p2 = new Player("Jose Bautista", 400);
		Player p3 = new Player("Michael Saunders", 298);

		Team c = new Team("Toronto Blue Jays");
		displayResults(c.getName().equals("Toronto Blue Jays"));
		displayResults(c.getPlayerCount() == 0);
		c.setName("Seattle Mariners");
		displayResults(c.getName().equals("Seattle Mariners"));

		Team c2 = new Team("New York Yankees", p1);
		displayResults(c2.getName().equals("New York Yankees"));
		displayResults(c2.getPlayerCount() == 1);
		displayResults(c2.getPlayer(0).equals(p1));
		c2.removePlayer(p1);
		displayResults(c2.getPlayerCount() == 0);
		c2.addPlayer(p2);
		c2.addPlayer(p3);
		displayResults(c2.getPlayerCount() == 2);
	}

	public static void main (String[] args)
	{
		try
		{
			PlayerTest();
			PlayerListTestOne();
			PlayerListTestTwo();
			PlayerListResizeTest();
			PlayerListStressTest();
			TeamTest();
		}
		catch (Exception e)
		{
			System.out.println("Your code threw an Exception.");
			System.out.println("Perhaps a stack trace will help:");
			e.printStackTrace(System.out);
		}
	}
}
