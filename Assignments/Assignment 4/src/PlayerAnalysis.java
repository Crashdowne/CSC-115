import java.util.*;
import java.io.*;

//This class consists exclusively of static methods that operate on or return 
//Lists of type Player and/or it subclasses. 

public class PlayerAnalysis{

	
	// PURPOSE:
	//	Given an empty list of type Fielder, and a filename of a file 
	//	containing Fielder statistical data, this method populates
	//  the list with a new Fielder object for every entry in the data file.
	// 	At the end of this method, l is a List of Fielder objects
	// 	sorted by name.
	public static void populateFielderList(List<Fielder> l, String filename) {
	
		try{
			File myFile = new File(filename);
			Scanner myScan = new Scanner(myFile);

			myScan.nextLine(); //consume headerline of text
		
			//player data fields
			String name;
			String position;
			int atBats;
			int hits;
			int bAvg;

			while(myScan.hasNextLine()) {
				name = (myScan.next() + " " + myScan.next());//get last name and first initial
				myScan.next(); //skip team
				position = myScan.next();
				myScan.next(); //skip G
				atBats = myScan.nextInt();
				myScan.next(); //skip R
				hits = myScan.nextInt();
				myScan.nextLine(); //skip to nextline
				bAvg = (int)((double)hits/atBats*1000);
			
				//need to create a new Fielder from above data 
				//add it to the list
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("File not Found " + e);
			System.exit(0);
		}
		
		// remember -- you can print your list with  
		// ListOperations.printList(l) for testing purposes
		// make sure you sort them alphabetically by name
		
	}
	
	// PURPOSE:
	//	Given an empty List of type Pitcher, and a filename of a file 
	//	containing Pitcher statistical data, this method populates
	//  the list with a new Fielder object for every entry in the data file.
	// 	At the end of this method, l is a List of Pitcher objects
	// 	sorted by name.
	public static void populatePitcherList(List<Pitcher> l, String filename) {
	
		try{
			
			File myFile = new File(filename);
			Scanner myScan = new Scanner(myFile);

			myScan.nextLine(); //consume headerline of text
		
			String name;
			float era;
			
			while(myScan.hasNextLine()) {
				name = (myScan.next() + " " + myScan.next());
				myScan.next(); //skip team
				myScan.next(); //skip W
				myScan.next(); //skip L
				era = myScan.nextFloat();
				myScan.nextLine(); //skip to nextline
			
				//need to create a new Pitcher from above data 
				//add it to the list
			}
	
		}catch (FileNotFoundException e) {
			System.out.println("File not Found " + e);
			System.exit(0);
		}
		
		//make sure you sort them alphabetically by name
	}

	
	// PURPOSE:
	//	Given a list of type Fielder and a list of type  
	//	Player, combines the elements of this into one 
	// 	list of type Player that is sorted alphabetically 
	//	by Player name
	// 
	// RETURN: 
	// 	an alphabetized List of Players
	public static List<Player> makeAlphaDraftList(List<Fielder> f, List<Pitcher> p) {

		return null;
	}
	
	// PURPOSE:
	//	Given a list of type Fielder and a list of type Player, 
	//	combines the elements of these lists into one list of type Player 
	// 	with 3 of each type of Fielder position and 10 Pitchers. 
	//
	//	Fielders placed on the list have the highest 
	//	batting average for their Position.
	//  Pitchers placed on the list have the lowest ERA. 
	//
	//  The resulting list is sorted by player position, 
	//	with each Fielder Position in descending batting average order
	//	and Pitchers in increasing ERA order.
	//	NOTE: this function is tested by comparing the lists, 
	//	not comparing the format of the output,
	// 	so your output does not have to match the output shown exactly
	//
	// RETURN: 
	// 	an ordered List of Players as described above
	//
	// EXAMPLE:
	/*
		Fielder, P:		1B	B_AVG: 313
		Butler, B:		1B	B_AVG: 312
		Gonzalez, A:	1B	B_AVG: 298
		Cano, R:		2B	B_AVG: 312
		Scutaro, M:		2B	B_AVG: 306
		Hill, A:		2B	B_AVG: 302
		Cabrera, M:		3B	B_AVG: 329
		Beltre, A:		3B	B_AVG: 321
		Pacheco, J:		3B	B_AVG: 309
		Posey, B:		C	B_AVG: 335
		Mauer, J:		C	B_AVG: 319
		Molina, Y:		C	B_AVG: 314
		McCutchen, A:	CF	B_AVG: 327
		Trout, M:		CF	B_AVG: 325
		Hunter, T:		CF	B_AVG: 312
		Braun, R:		LF	B_AVG: 319
		Murphy, D:		LF	B_AVG: 304
		Gonzalez, C:	LF	B_AVG: 303
		Craig, A:		RF	B_AVG: 307
		Revere, B:		RF	B_AVG: 293
		Ethier, A:		RF	B_AVG: 284
		Jeter, D:		SS	B_AVG: 316
		Desmond, I:		SS	B_AVG: 292
		Escobar, A:		SS	B_AVG: 292
		Kershaw, C:		P	ERA:1.77
		Hernandez, F:	P	ERA:2.14
		Sale, C:		P	ERA:2.17
		Cueto, J:		P	ERA:2.25
		Wainwright, A:	P	ERA:2.38
		Fister, D:		P	ERA:2.41
		Kluber, C:		P	ERA:2.44
		Hamels, C:		P	ERA:2.46
		Lester, J:		P	ERA:2.46
		Richards, G:	P	ERA:2.61
	*/
	public static List<Player> makeShortDraftList(List<Fielder> f, List<Pitcher> p)  {

		return null;	
	}


}