/*
 * PlayerList.java
 *
 * A definition of the List ADT that can store items of type Player
 *
 * Later in the course we'll see how to implement a List that can
 * store items of an arbitrary type.
 *
 */

public interface PlayerList

{

	/*
	 * PURPOSE:
	 *   Add the element p at position pos in the list.
	 *
	 * PRECONDITIONS:
	 *   0 < pos < count
	 *
	 * RETURNS:
	 *   None.
	 *
	 * Examples:
	 * If l is {1,2,3} and l.addAt(9,1) returns, then l is {1,9,2,3}.
	 * If l is {4,5,6} and l.addAt(9,2) returns, then l is {4,5,9,6}.	 
	 * If l is {} and l.addAt(9,0) returns, then l is {9}.
	 */		

	public void addAt (Player p, int pos);

	/*
	 * PURPOSE:
	 *   Add the element p to the end of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * RETURNS:
	 *   None.
	 * 
	 * Examples:
	 * If l is {1,2,3} and l.append(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.append(9) returns, then l is {9}.
	 */		
	 
	public void append (Player p);

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * RETURNS:
	 *   The size of the list.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */

	public int size();
	

	/* 
	 * PURPOSE:
	 *   Return the element at position pos in the list.
	 * 
	 * PRECONDITIONS:
	 *   0 < pos < count
	 *
	 * RETURNS:
	 *   The Player at position pos in the list.
	 * 
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *
	 */

	public Player  get (int pos);

	/* 
	 * PURPOSE:
	 *  Returns the index of the first occurrence of player p in the list.
	 *	If not found returns -1.
	 * 
	 * PRECONDITIONS:
	 *   None.
	 *
	 * RETURNS:
	 *   If found, returns the position of player in the list.
	 *   If not found, -1.
	 * 
	 * Examples:
	 *	If l is {67,12,13} then l.find(12) returns 1
	 *	If l is	{67,12,13,67} then l.find(67) returns 0
	 *	If l is {92} then the result of l.find(2) returns -1.
	 *	If l is {} then the result of l.find(4) returns -1.
	 *
	 */
	 
	public int find (Player p);
	
	/* 
	 * PURPOSE:
	 *   Remove all elements from the list.  After calling this
	 *   method on a list l, l.size() will return 0
	 * 
	 * PRECONDITIONS:
	 *	None.
	 *
	 * RETURNS:
	 *   None.
	 * 
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	 
	public void clear();

	/* 
	 * PURPOSE:
	 *   Remove all instances that match player p from the list. 
	 * 
	 * PRECONDITIONS:
	 *	None.
	 *
	 * RETURNS:
	 *   None.	 
	 * 
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 *	If l is {} then after l.remove(99), l is {}	 
	 */
	 
	public void remove (Player p);

	/* 
	 * PURPOSE:
	 *   Remove the element at position pos from the list. 
	 * 
	 * PRECONDITIONS:
	 *   0 < pos < count	
	 *
	 * RETURNS:
	 *   None.
	 * 
	 * Examples:
	 *	If l is {67,12,13} then after l.removeAt(2), l is {67,13}
	 *	If l is {1,3,5} then after l.removeAt(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(0), l is {2,3}
	 */
	 
	public void removeAt (int pos);
	
	/*
	 * PURPOSE:
	 *	Return a string representation of the list
	 * 
	 * PRECONDITIONS:
	 *	None.
	 *
	 * RETURNS:
	 *   None.
	 *
	 * Examples:
	 *	If l is {1,2,3,4} then l.toString() returns "{1,2,3,4}"
	 *	If l is {} then l.toString() returns "{}"
	 *
	 */

	public String toString();

}

