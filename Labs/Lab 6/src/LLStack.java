public class LLStack implements Stack{// set LLStack so that it implements the Stack interface
	private Node head;
	private int count;
	private boolean isEmpty;
	
	
	
	public LLStack(){
		this.head = null;
		this.count = 0;	
	}

	public void push(Object item) {
		Node nn = new Node(item);

		if(isEmpty == true)
		{
			this.head = nn;
			this.count++;
		}
		else
		{
			nn.setNext(head);
			head = nn;
			count++;
		}
		
	}

	public Object peek() {
		
		return this.head;
	}

	public boolean isEmpty() {
		if(this.count == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public Object pop() {
		head = head.getNext();
		count --;
		return head;
	}
	
	public String toString(){
		Node currentNode = this.head;
        int index=0;
                
        if(isEmpty() == true)
        {
            return "{}";
        }
        
        String s = "{";        
        s+=currentNode.toString();
        
        while(currentNode.getNext() != null)
        {
            if(index < this.count)
            {
                s+=",";
            }    
            currentNode = currentNode.getNext();
            s+=currentNode.toString();
            index++;
        }
        
        s+= "}";
        return s;
	}

	public static void main(String[] args){
		//Uncomment this section to test adding to the stack.
		Stack testStack = new LLStack();
		testStack.push("first item");
		testStack.push("second item");
		testStack.push("third item");
		System.out.println(testStack);

		System.out.println("Top item is " + testStack.peek());

		System.out.println("Is the stack empty? " + testStack.isEmpty());

		
		testStack.pop();
		testStack.pop();
		testStack.push("fourth item");
		System.out.println("Contents of the stack after popping two items and adding a fourth: " + testStack);
		testStack.pop();
		testStack.pop();
		System.out.println("Is the stack empty after popping two more times? " + testStack.isEmpty());
	}


}