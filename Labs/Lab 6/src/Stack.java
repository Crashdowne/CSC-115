public interface Stack{
	// Adds the specified item to the top of the Stack.
	public void push(Object item);

	// Returns the item on top of the Stack.
	public Object peek();

	// Returns true if the Stack is empty, false otherwise.
	public boolean isEmpty();

	// Removes and returns the item on top of the Stack.
	public Object pop();
}