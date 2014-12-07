
public class TestGenericLL

{
	public static void main(String[] args)
	{
		LLInterface<Integer> s1 = new LLStudying<Integer>();
		s1.insertFront(1);
		s1.insertFront(2);
		s1.insertFront(3);
		s1.insertFront(4);
		s1.insertFront(5);
		s1.insertFront(6);
		System.out.println(s1.toString());
	}
}
