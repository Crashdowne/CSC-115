import java.util.*;
public class HashtableSC{
	private java.util.LinkedList<KeyValuePair> table[];
	private int tableSize;
	private int size;
	private int collisionCount;

	public HashtableSC(int capacity){
		table = new java.util.LinkedList[capacity];
		tableSize = capacity;
		// Count number of objects
		size = 0;
		collisionCount = 0;

		// Create a linked list for each index in the hashtable.
		for (int i = 0; i < capacity; i++){
			table[i] = new java.util.LinkedList<KeyValuePair>();
		}
	}

	public String toString(){
		String result = "HashTable with " + size + " item(s), a capacity of " + tableSize;
		result += " and load factor: "+(size+0.0)/tableSize + "\n";

		for (int i = 0; i < tableSize; i++){
			if (table[i] != null){
				result += "Index " + i + " --- " + table[i].toString() + "\n";
			}
		}
		return result;
	}

	public int getCollisionCount(){
		return collisionCount;
	}

	/**
	 * This is the hash function that simply mods the key by the size of the array.
	 */
	private int hashFunction1( int key ){
		return key%tableSize;
	}

	/**
	 * This is the hash function that appends the 8 bit binary representative for the value (0...9) of
	 * each digit in the integer and then mods the array size.
	 */
	private int hashFunction2( int key ){
		String s = ((Integer)key).toString().toLowerCase();
		long total = 0;
		int charValue;
		char ch;
		
		for (int i=0; i<s.length(); i++) {
			ch = s.charAt(i);
			charValue = (ch - '0');
			total = (total << 5) + charValue;
			total %= tableSize;
		}
		return (int)total;
	}

	public void increaseCapacity(int newCapacity){
		java.util.LinkedList<KeyValuePair> tempTable[] = table;
		table = new LinkedList[newCapacity];

		// Create a linked list for each index in the hashtable.
		for (int i = 0; i < newCapacity; i++){
			table[i] = new java.util.LinkedList<KeyValuePair>();
		}
		size = 0;
		tableSize = newCapacity;
		collisionCount = 0;

		for (int i = 0; i < tempTable.length; i++){
			while (tempTable[i].size() > 0){
				KeyValuePair item = tempTable[i].removeFirst();
				insert(item.getKey(), item.getValue());
			}
		}
	}

	public boolean isFull(){
		return (size == tableSize);
	}


	// Inserts the key and value pair into the table array.
	public void insert(int key, Object value){
		
		int insertPos;

		insertPos = hashFunction1(key);
		KeyValuePair newItem = new KeyValuePair(key, value);
		
		if(table[insertPos].isEmpty() == false)
		{
			collisionCount++;
		}
		
		table[insertPos].addFirst(newItem);
		size++;

		// FILL IN THIS METHOD
		//	hash the key to figure out the index in the table where the data should be added - start by using hashFunction1.
		//	if there is already data at that index, increment the collisionCount.
		//	add the data to the front of the linked list at that index.
	}

	// Finds and return the item with the given key. If there is no item with the given key in the hashtable, return null.
	public Object find(int key){
		
		int searchIndex = hashFunction1(key);
		
		// Slow method
		/*
		for(int i=0; i<table[searchIndex].size(); i++)
		{
			KeyValuePair current = table[searchIndex].get(i);
			if(current.getKey() == key)
			{
				return current.getValue();
			}
		}
		*/
		
		// Faster
		
		Object[] chain = table[searchIndex].toArray();
		
		for(int i=0; i<table[searchIndex].size(); i++)
		{
			KeyValuePair current = (KeyValuePair) chain[i];
			if(current.getKey() == key)
			{
				return current.getValue();
			}
		}
		
		// FILL IN THIS METHOD
		// hash the key to figure out the index in the table where the data should appear.
		// check if data with the given key is stored in that index.
		// 		to do this, you will need to search the linked list at that index. One way to accomplish this is to use the toArray() method
		//		of the LinkedList class to convert the linked list to an Object[] that you can loop through.
		return null;
	}

	// Finds and removes the item with the given key.
	public void delete(int key){
		
		int pos = hashFunction1(key);
		
		for(int i=0; i<table[pos].size(); i++)
		{
			KeyValuePair current = table[pos].get(i);
			if(current.getKey() == key)
			{
				table[pos].remove(i);
			}
			size--;
			break;
		}
		
		// FILL IN THIS METHOD
		// hash the key to figure out the index in the table where the data should appear.
		// check if data with the given key is stored in that index.
		// 		to do this, you will need to search the linked list at that index. One way to accomplish this is to use the toArray() method
		//		of the LinkedList class to convert the linked list to an Object[] that you can loop through.
		//			If you find the data you're looking to delete, you can use one of the remove() methods from the LinkedList class to get
		//			rid of that data.
	}

	public static void main(String[] args){
		HashtableSC hashtable = new HashtableSC(10);
		hashtable.insert(42, "Jeremy");
		hashtable.insert(55, "Gautam");
		hashtable.insert(38, "Donna");
		hashtable.insert(25, "Victoria");
		hashtable.insert(19, "Ali");
		hashtable.insert(13, "Bob");
		hashtable.insert(32, "Ackbar");
		hashtable.insert(12, "Tovak");
		hashtable.insert(23, "Minos");
		System.out.println(hashtable);
		System.out.println("Number of Collisions: " + hashtable.getCollisionCount() + "\n");
		
		
		// UNCOMMENT THIS TO TEST THE find METHOD
		System.out.println("Searching for key 32 (should be Ackbar): " + hashtable.find(32));
		System.out.println("Searching for key 9 (should be null): " + hashtable.find(9));


		hashtable.increaseCapacity(20);
		System.out.println(hashtable);

		System.out.println("Number of Collsions: " + hashtable.getCollisionCount() + " \n");

		
		// UNCOMMENT THIS TO TEST THE delete METHOD
		System.out.println("Removing key 23 (Minos)");
		hashtable.delete(23);
		System.out.println("Searching for key 23 (should now be null): " + hashtable.find(23) + "\n");
		System.out.println(hashtable);
		
	}
}