/*
 * CSC 115 Assignment 2
 * Bryan Kesteloo
 * V00718963
 * Creates a doubly-linked list implementing the PlayerList interface
 *
 */

public class PlayerLinkedList implements PlayerList

{
    private PlayerNode head;
    private PlayerNode tail;
    private int count;

    public PlayerLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }
    
    public boolean isListEmpty()
    {
        return this.count == 0;
    }
    
    public boolean isBeginningOfList(int pos)    
    {
        return pos == 0;
    }

    public void addAt (Player p, int pos)
    {    
        if(pos < 0)
        {
            System.out.println("Position cannot be less than 0");
            return;
        }
        else if(pos > this.count)
        {
            System.out.println("Position cannot be greater than or equal to " + count);
            return;
        }
        
        PlayerNode newNode = new PlayerNode(p);
        // Bug in the PlayerNode class where we don't set PlayerNode.prev to null in the constructor
        newNode.prev = null;
        PlayerNode currentNode;

        
        if(isListEmpty() == true)
        {
            this.head = newNode;
            this.tail = newNode;

        }        
        else if(isBeginningOfList(pos) == true)
        {
        	this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }        
        else
        {
            currentNode = this.head;
            // Get the node before the position that we want to add
            for(int i=0; i<pos-1; i++)
            {
                currentNode = currentNode.next;
            }
            newNode.prev = currentNode;
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        
        this.count++;
    }

    public void append (Player p)
    {
        PlayerNode newNode = new PlayerNode(p);
        // Bug in the PlayerNode class where we don't set PlayerNode.prev to null in the constructor
        newNode.prev = null;
        		
        if(isListEmpty() == true)
        {
            this.head = newNode;
            this.tail = newNode;
            this.count++;
        }
        else
        {
        	newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
            this.count++;
        }
    }

    public int size()
    {
        return this.count;
    }
    

    public Player get (int pos)
    {
        PlayerNode currentNode = this.head;
        for(int i=0; i<pos; i++)
        {
            currentNode = currentNode.next;    
        }
        return currentNode.p;
    }

    public int find (Player p)
    {
        PlayerNode currentNode;
        currentNode = this.head;
        int index=0;
        
        for(int i=0; i<count; i++)
        {            
            if(currentNode.getPlayer().equals(p))
            {
                return index;    
            }
            currentNode = currentNode.next;
            
            index++;
        }
        return -1;
    }
     
    public void clear()
    {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }
    
    public void removeAt (int pos)
    {
        PlayerNode currentNode;
        currentNode = this.head;
        
        if(pos < 0)
        {
            System.out.println("Position cannot be less than 0");
            return;
        }        
        else if(pos > this.count)
        {
            System.out.println("Position cannot be greater than equal to "+count);
            return;
        }        
        else if(count == 1)
        {
            clear();
            return;
        }        
        else if(pos == 0)
        {
            this.head = currentNode.next;
            this.head.prev = null;
            
        }
        else if(pos > 0)
        {
            for(int i=0; i<pos-1; i++)
            {
                currentNode = currentNode.next;
            }
            
            // If we remove the last element of the list we dont need to change its .prev field
            if(currentNode.next.next != null)
            {
            	currentNode.next.next.prev = currentNode;
            }
            currentNode.next = currentNode.next.next;
        }
        
        this.count--;
    }
     
    public void remove (Player p)
    {
        PlayerNode currentNode = this.head;
        int index = 0;
        
        if(currentNode.getPlayer().equals(p))
        {
            removeAt(index);
            // we just removed an element so our index must be shifted down one
            index--;
        }
        
        while(currentNode.next != null)
        {
            currentNode = currentNode.next;
            index++;
            
            if(currentNode.getPlayer().equals(p))
            {
                removeAt(index);
                // we just removed an element so our index must be shifted down one
                index--;
            }
        }
    }

    public String toString()
    {
        PlayerNode currentNode = this.head;
        int index=0;
        
        if(isListEmpty() == true)
        {
            return "{}";
        }
                
        String s = "{";        
        s+=currentNode.getPlayer().toString();
        
        while(currentNode.next != null)
        {
            if(index < this.count)
            {
                s+=",";
            }    
            currentNode = currentNode.next;
            s+=currentNode.getPlayer().toString();
            index++;
        }
        
        s+= "}";
        return s;
    }
    
    /*
     * Here you see some basic testing I did before moving on to
     * the more detailed testing provided by a2tester.java
     *
     * You can run this by typing:
     * javac PlayerArrayList.java
     * java PlayerArrayList
     *
     */
    public static void main (String[] args)
    {
    
        PlayerLinkedList l = new PlayerLinkedList();
        
        System.out.println(l);
        l.append(new Player("one"));
        l.append(new Player("two"));
        l.append(new Player("ten"));
        l.append(new Player("five"));
        System.out.println(l);
        System.out.println();
        
        l.clear();
        System.out.println(l);
        System.out.println();
        
        l.addAt(new Player("one"),0);
        l.addAt(new Player("two"),0);
        l.addAt(new Player("ten"),0);
        l.addAt(new Player("five"),2);
        System.out.println(l);
        System.out.println();
    }
}

