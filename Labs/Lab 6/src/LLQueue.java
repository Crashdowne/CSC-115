public class LLQueue implements Queue{ // set this class to implement the Queue interface
	// We need to keep track of both ends of the queue, we accomplish this in a linked list
	// by storing head and tail references.
	private Node head;
	private Node tail;
	private int count;

	public LLQueue(){
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	public boolean isEmpty()
	{
		if (count == 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public void enqueue(Object item)
	{
		Node nn = new Node(item);
		
		if (isEmpty() == true)
		{
			this.head = nn;
			this.tail = nn;
			this.count++;
		}
		
		else
		{
			tail.setNext(nn);
			tail = nn;
			count++;
		}
	}
	
	public Object dequeue() 
	{
		if (isEmpty() == true)
		{
			return null;
		}

		else
		{
			this.head = head.getNext();
			count--;
		}
		return this.head;
	}

	public Node peek()
	{
		return this.tail;
	}
	

	public String toString(){
		Node currentNode = this.tail;
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

		Queue testQueue = new LLQueue();
		testQueue.enqueue("first item");
		testQueue.enqueue("second item");
		testQueue.enqueue("third item");
		System.out.println(testQueue);

		
		System.out.println("First item is " + testQueue.peek());

		
		System.out.println("Is the queue empty? " + testQueue.isEmpty());

		
		testQueue.dequeue();
		testQueue.dequeue();
		testQueue.enqueue("fourth item");
		System.out.println("Contents of the queue after dequeueing two items and enqueueing a fourth item: " + testQueue);
		testQueue.dequeue();
		testQueue.dequeue();
		System.out.println("Is the queue empty after dequeueing two more times? " + testQueue.isEmpty());
	}

	
}