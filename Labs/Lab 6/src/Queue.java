public interface Queue{
	// Adds the specified item at the end of the queue.
	public void enqueue(Object item);

	// Returns the item at the front of the queue.
	public Object peek();

	// Returns true if the queue is empty, false otherwise.
	public boolean isEmpty();

	// Returns and removes the front item of the queue.
	public Object dequeue();
}