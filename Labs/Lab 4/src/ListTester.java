public class ListTester{
	public static void main (String[] args)
	{
		IntegerList l = new IntegerSLL("Integer Singly-Linked List");
		//IntegerList l = new IntegerSLLT("Integer Singly-Linked List");
		
		System.out.println(l);
		l.addBack(3);
		l.addFront(2);
		l.addFront(1);
		l.addBack(4);
		System.out.println(l);

		l.clear();
		
		l.addBack(2);
		l.addBack(3);
		l.addBack(5);
		l.addFront(5);
		l.addFront(1);
		l.addFront(5);
		System.out.println(l + "\n");
		l.remove(5);
		System.out.println(l);
		
		l.addBack(4);
		System.out.println(l);	
		
	}	
}