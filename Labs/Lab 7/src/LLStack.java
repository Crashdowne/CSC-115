public class LLStack<T>{
	
	private Node head;
	
	public LLStack(){
		head = null;
	}

	public void push(T item){
		Node<T> newNode = new Node(item);
		newNode.setNext(head);
		head = newNode;
	}


	public Object peek(){
		return head.getData();
	}


	public boolean isEmpty(){
		return (head == null);
	}

	public Object pop(){
		Object firstItem = head.getData();
		head = head.getNext();
		return firstItem;
	}
	
	public String toString(){
		String result = "Stack:";
		Node currentNode = head;
		while (currentNode != null){
			result += " -> " + currentNode.getData();
			currentNode = currentNode.getNext();
		}
		return result;
	}

	public static void main(String[] args){
		/*
		LLStack<String> testStack = new LLStack<String>();
		testStack.push("first item");
		testStack.push("second item");
		testStack.push("third item");
		System.out.println("\n" + testStack);
		System.out.println("Top item is " + testStack.peek());
		System.out.println("Is the stack empty? " + testStack.isEmpty());
		testStack.pop();
		testStack.pop();
		testStack.push("fourth item");
		System.out.println("Contents of the stack after popping two items and adding a fourth: \n" + testStack);
		testStack.pop();
		testStack.pop();
		System.out.println("Is the stack empty after popping two more times? " + testStack.isEmpty() + "\n\n");
		
		/*
		LLStack<Integer> testStack2 = new LLStack<Integer>();
		testStack2.push(1);
		testStack2.push(2);
		testStack2.push(3);
		System.out.println(testStack2);
		System.out.println("Top item is " + testStack2.peek());
		System.out.println("Is the stack empty? " + testStack2.isEmpty());
		testStack2.pop();
		testStack2.pop();
		testStack2.push(4);
		System.out.println("Contents of the stack after popping two items and adding a fourth: \n" + testStack2);
		testStack2.pop();
		testStack2.pop();
		System.out.println("Is the stack empty after popping two more times? " + testStack2.isEmpty());
		*/
		
	}
}