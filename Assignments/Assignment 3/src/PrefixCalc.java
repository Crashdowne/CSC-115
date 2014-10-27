/*
 * CSC 115 Assignment 3
 * Bryan Kesteloo
 * V00718963
 * Calculates results based on prefixes and numbers given from the command line
 */

public class PrefixCalc 
{
	public static void main(String args[]) throws StackEmptyException, NumberFormatException
	{
		PrefixCalc calc = new PrefixCalc();
		calc.calculator(args);	
	}
	
	public String calculator(String[] args)
	{
		Stack<String> s1 = new LLStack<String>();
		int value = 0;

		try
		{
			for(int i=0; i<args.length; i++)
			{
				if(isOperator(args[i]) == true)
				{
					String input = args[i];
					s1.push(input);
				}
				else
				{
					value = Integer.parseInt(args[i]);
					while(s1.size() != 0 && isOperator(s1.peek()) != true)
					{
						int poppedValue = Integer.parseInt(s1.pop());
						String operator = s1.pop();
						
						if(s1.size() != 0 && isOperator(operator) != true)
						{
							System.out.println("invalid expression");
							return "invalid expression";
						}
						
						value = operations(value, poppedValue, operator);
					}
					String output = Integer.toString(value);
					s1.push(output);
				}
			}
			
			if(s1.size() == 1)
			{
				System.out.println(s1.pop());
			}
			else
			{
				System.out.println("invalid expression");
				return "invalid expression";
			}
		}
		catch (StackEmptyException | NumberFormatException e)
		{
			System.out.println("invalid expression");
			return "invalid expression";
		}
		
		return Integer.toString(value);	
	}
	
	private boolean isOperator(String s)
	{
		if(s.equalsIgnoreCase("+") || s.equalsIgnoreCase("-") || s.equalsIgnoreCase("x") || s.equalsIgnoreCase("/"))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	private int operations(int value, int poppedValue, String operator) throws NumberFormatException
	{
		int calculatedValue;
		
		if(operator.equals("+"))
		{
			calculatedValue = poppedValue + value;
		}
		else if(operator.equals("-"))
		{
			calculatedValue = poppedValue - value;
		}
		else if(operator.equals("x"))
		{
			calculatedValue = poppedValue * value;
		}
		else if(operator.equals("/"))
		{
			calculatedValue = poppedValue / value;
		}
		else
		{
			throw new NumberFormatException("invalid expression");
		}

		return calculatedValue;
	}

}
