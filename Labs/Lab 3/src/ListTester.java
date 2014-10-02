public class ListTester{
	public static void main (String[] args)
	{
		IntegerList l = new IntegerArrayList();
		
		System.out.println(l);
		l.addFront(3);
		l.addFront(10);
		l.addFront(1);
		l.addFront(22);
		System.out.println(l);

		l.clear();
		
		l.addBack(3);
		l.addBack(10);
		l.remove(10);
		l.addBack(1);
		l.addFront(22);
		System.out.println(l);	
	}	
}