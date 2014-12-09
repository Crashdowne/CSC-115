
public interface LL<T>
{
	int size();
	boolean empty();
	void insertFront(T data);
	void insertBack(T data);
	void removeFront() throws StackEmptyException;;
	void removeBack() throws StackEmptyException;;
	void removeSecondLast();
	void makeEmpty();
}
