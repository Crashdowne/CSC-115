public class LLQueue<T>{
	private Node head;
	private Node tail;

	public LLQueue(){
		head = null;
		tail = null;
	}


	public void enqueue(Object item){
		Node newNode = new Node(item);
		if (tail == null){
			tail = newNode;
			head = newNode;
		}else{
			tail.setNext(newNode);
			tail = newNode;
		}
	}


	public Object peek(){
		return head.getData();
	}


	public boolean isEmpty(){
		return (head == null);
	}

	public Object dequeue(){
		Object firstItem = head.getData();
		head = head.getNext();
		if (head == null){
			tail = null;
		}
		return firstItem;
	}
	
	public String toString(){
		String result = "Queue:";
		Node currentNode = head;
		while (currentNode != null){
			result += " -> " + currentNode.getData();
			currentNode = currentNode.getNext();
		}
		return result;
	}

	public static void main(String[] args){
	   
		LLQueue<String> testQueue = new LLQueue<String>();
		testQueue.enqueue("first item");
		testQueue.enqueue("second item");
		testQueue.enqueue("third item");
		System.out.println(testQueue);
		System.out.println("First item is " + testQueue.peek());
		System.out.println("Is the queue empty? " + testQueue.isEmpty());
		testQueue.dequeue();
		testQueue.dequeue();
		testQueue.enqueue("fourth item");
		System.out.println("Contents of the queue after dequeueing two items and enqueueing a fourth item: \n" + testQueue);
		testQueue.dequeue();
		testQueue.dequeue();
		System.out.println("Is the queue empty after dequeueing two more times? " + testQueue.isEmpty() + "\n\n");
		
		
		LLQueue<Integer> testQueue2 = new LLQueue<Integer>();
		testQueue2.enqueue(1);
		testQueue2.enqueue(2);
		testQueue2.enqueue(3);
		System.out.println(testQueue2);
		System.out.println("First item is " + testQueue2.peek());
		System.out.println("Is the queue empty? " + testQueue2.isEmpty());
		testQueue2.dequeue();
		testQueue2.dequeue();
		testQueue2.enqueue(4);
		System.out.println("Contents of the queue after dequeueing two items and enqueueing a fourth item: " + testQueue2);
		testQueue2.dequeue();
		testQueue2.dequeue();
		System.out.println("Is the queue empty after dequeueing two more times? " + testQueue2.isEmpty());
		
	}
}