/**
 * Queue.java
 * Lucy Lu and Allie Warren, 3/15/14
 * Used to store words for breadth first search
 * Queue is implemented as a Linked List
 */
public class Queue {
	private LinkedList list;
	
	//Queue constructor
	public Queue() {
		// Create a new LinkedList.
		list = new LinkedList();
	}

	// Returns true if the queue is empty. Otherwise, false.
	public boolean isEmpty() {
		return (list.size() == 0);
	}

	// An item is added to the back of the queue, by adding it to the end of a linked list
	public void enqueue(String item)	{
		list.add(item);
	}

	//The item at the front of the queue is returned and removed from the queue
	public String dequeue() {
		String w = list.get(0);
		list.remove(0);
		return w;
	}

	//Returns the item at the front of the queue but does not delete it
	public String peek() {
		return list.get(0);
	}
}