import java.util.*;
class Queue {
   private LinkedList items;
   public Queue(){
	  items = new LinkedList();
   }

   public void enqueue(Object item) {
      items.addLast(item);
   }
   public Object dequeue() {
      return items.removeFirst();
   }
   public boolean isEmpty() {
      return (items.size() == 0);
   }
}