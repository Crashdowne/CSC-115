import java.io.*;
import java.util.*;


public class Lab2Main {

	public static void main(String[] args)
	{
		// Using args in the string[] in the main method, you need to add things / arguments to it
		// Need to set arguments in that String[] to correspond to a position in that array / initialize it
		// Work on args!
		// Try Catch
	
		
		fileInput();
	}
	
	public static void fileInput()
	{
		try 
		{
			Scanner f = new Scanner(new File("input.txt"));
			int arraySize = f.nextInt();
			double[] ar = new double[arraySize];
			
			while (f.hasNext())
			{
				double pos = f.nextDouble();
				double value = f.nextDouble();
				ar[((int) pos)-1] = value;
			}
			
			System.out.print(Arrays.toString(ar));
		} 
		
		catch (FileNotFoundException e) 
		{
			System.out.println("Cannot locate file");
		}
	}
}
