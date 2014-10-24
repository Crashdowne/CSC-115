public class Node<T>{
	private T data;
	private Node<T> next;

	public Node(T newData){
		data = newData;
	}

	public T getData(){
		return data;
	}

	public Node<T> getNext(){
		return next;
	}

	public void setData(T newData){
		data = newData;
	}

	public void setNext(Node<T> newNext){
		next = newNext;
	}

	public String toString(){
		return data.toString();
	}
}
