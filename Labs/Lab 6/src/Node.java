public class Node{
	private Object data;
	private Node next;

	public Node(Object newData){
		data = newData;
	}

	public Object getData(){
		return data;
	}

	public Node getNext(){
		return next;
	}

	public void setData(Object newData){
		data = newData;
	}

	public void setNext(Node newNext){
		next = newNext;
	}

	public String toString(){
		return data.toString();
	}
}