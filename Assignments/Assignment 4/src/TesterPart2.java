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

public class TesterPart2
{
	public static int  	testCount = 0;


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

	public static void testPlayerCompareTo()
	{
		System.out.println("Testing player analysis");

		Player p1 = new Pitcher("A");
		Player p2 = new Pitcher("B");
		Player p3 = new Pitcher("A");
		
		displayResults(p1.compareTo(p2) < 0);
		displayResults(p2.compareTo(p1) > 0);
		displayResults(p1.compareTo(p3) == 0);

	}
	
	
	public static void testPlayerAnalysis()
	{
		System.out.println("Testing populate fielder/player lists in sorted order");

		List<Fielder> fCorrect = new LinkedList<Fielder>();
		List<Pitcher> pCorrect = new LinkedList<Pitcher>();
		
		PlayerAnalysisSoln.populateFielderList(fCorrect, "fielderData.txt");
		PlayerAnalysisSoln.populatePitcherList(pCorrect, "pitcherData.txt");
		
		List<Fielder> fResult = new LinkedList<Fielder>();
		List<Pitcher> pResult = new LinkedList<Pitcher>();
		
		PlayerAnalysis.populateFielderList(fResult, "fielderData.txt");
		PlayerAnalysis.populatePitcherList(pResult, "pitcherData.txt");	
		
		
		displayResults(fResult.size() == fCorrect.size());
		
		for(int i=0; i<fCorrect.size(); i++) {
			if(!fResult.get(i).equals(fCorrect.get(i))){
				displayResults(false);	
			}	
		}
		displayResults(true);	
		
		displayResults(pResult.size() == pCorrect.size());
		
		for(int i=0; i<pCorrect.size(); i++) {
			if(!pResult.get(i).equals(pCorrect.get(i))){
				displayResults(false);	
			}	
		}
		displayResults(true);
		
		System.out.println("Testing creation of full player lists in name sorted order");
		List<Player> playersCorrect = PlayerAnalysisSoln.makeAlphaDraftList(fCorrect,pCorrect);
		//ListOperations.printList(playersCorrect);
		
		List<Player> playersResult = PlayerAnalysis.makeAlphaDraftList(fResult,pResult);
		
		displayResults(playersResult!=null && playersResult.size() == playersCorrect.size());
		
		for(int i=0; i<playersCorrect.size(); i++) {
			if(!playersResult.get(i).equals(playersCorrect.get(i))){
				displayResults(false);	
			}	
		}
		displayResults(true);	
		
		System.out.println("Testing creation of short list sorted by position "+
		"then by decreasing order in batting average for fielders and increasing"+ 
		"ERA for pitchers.");		
		List<Player> correctSL = PlayerAnalysisSoln.makeShortDraftList(fCorrect, pCorrect);
		List<Player> resultSL = PlayerAnalysis.makeShortDraftList(fResult, pResult);
		ListOperations.printList(correctSL);

		
		displayResults(resultSL!=null && resultSL.size() == correctSL.size());
		
		for(int i=0; i<correctSL.size(); i++) {
		
			if(!resultSL.get(i).equals(correctSL.get(i))){
				displayResults(false);	
			}	
		}
		displayResults(true);
	
	}

	

	public static void main (String[] args)
	{	
		testPlayerCompareTo();
		testPlayerAnalysis();

	}
}
