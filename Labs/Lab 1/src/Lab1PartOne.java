import java.util.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class Lab1PartOne {

	public static void main(String[] args)
	{
		// Prints generic welcome message
		System.out.println("Welcome to CSc-115:");
		
		// Creates an integer with the value of 1
		int num = 1;
		
		// Creates the various strings
		String s1 = "This is the First String, ";
		String s2 = "This is the Second String, ";
		String s3 = "The number is: ";
		
		// Combines the strings as an example of one method of combining them
		String combined = s1 + s2;
		
		// Concatenates the 3 strings and the num integer
		System.out.println(s1 + s2 + s3 + num);
		
		// Calls method loops
		// loops();
		
		//arrays();
		//arrayCopy();
		
		int[] a1 = {5,6,8,17,55,1,3,4,8};
		int number = 3;
		
		returnNumbers(a1, number);
		
		int[] a2 = {5,6,8,17,55,1,3,4,8};
		arraySort(a2);
	}
	
	public static void loops()
	{
		// Prints 1 - 10
		for(int i=1; i<=10; i++)
		{
			System.out.print(" "+i);
		}
		
		// Blank line
		System.out.println();
		
		// Prints 0 - 9
		for(int i=0; i<10; i++)
		{
			System.out.print(" "+i);
		}
		
		// Blank Line
		System.out.println();
		
		// Nested loops that increases the number of stars
		for (int i=1; i<=5; i++)
		{
			for (int j=0; j<i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		// Needs work
		for (int i=1; i<=5; i++)
		{
			for (int j=5; j>i; j--)
			{
				System.out.print(" ");
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void arrays()
	{
		int[] oneToTen = new int[10];
		
		for (int i=0; i<10; i++)
		{
			oneToTen[i] = i+1;
		}
		
		System.out.println();
		
		System.out.print(Arrays.toString(oneToTen));
		
		System.out.println();
		System.out.println();
		
		for ( int i=0; i<oneToTen.length; i++)
		{
			if (oneToTen[i]%3 == 0 || oneToTen[i]%5 == 0)
			{
				System.out.print(oneToTen[i]+" ");
			}
		}
		
		System.out.println();
		
		for (int i=0; i<oneToTen.length; i+=2)
		{
			System.out.print(oneToTen[i]);
		}
	}
	
	public static void arrayCopy()
	{
		int[] arr = new int[10];
		
		int[] arr2 = new int[10];
		
		for (int i=0; i<10; i++)
		{
			arr[i] = i+1;
		}
		
		int counter =9;
		for (int i=0; i<arr.length; i++)
		{
			arr2[counter] = arr[i];
			counter--;
		}
	
		System.out.print(Arrays.toString(arr2));
	}
	
	public static int returnNumbers(int[] numbers, int multiple)
	{
		int count =0;
		
		for (int i=0; i<numbers.length; i++)
		{
			if (numbers[i]%3 == 0)
			{
				count++;
			}
		}
		
		System.out.println(count);
		return count;
	}
	
	public static int[] arraySort(int[] a1)
	{
		int[] decending = new int[a1.length];
		
		
		int largestNum = 0;
		int decendingPos = 0;
		
		for( int j=1; j<decending.length; j++)
		{
			for (int i=0; i<a1.length; i++)
			{
				if (a1[i] > largestNum && a1[i] != decending[i])
				{
					largestNum = a1[i];
				}
			}
			decending[j] = largestNum;
			largestNum =0;
		}
		

		
		System.out.print(Arrays.toString(decending));
				
		return decending;		
		
	}
}
