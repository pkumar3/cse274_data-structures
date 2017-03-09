/**
 * A Linked implementation of the StackInterface
 * 
 * @author Pranshu Kumar
 */
import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {
	
	private Node topNode;
	
	public LinkedStack() {
		topNode = null;
	}

	/** Adds a new entry to the top of this stack.
	 *  @param newEntry  An object to be added to the stack.
	 */
	@Override
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}

	/**
	 * Removes and returns this stack's top entry.
	 * 
	 * @return  The object at the top of the stack.
	 * @throws  EmptyStackException if the stack is empty before the operation.
	 */
	@Override
	public T pop() {
		T top = peek();
		
		assert topNode != null;
		topNode = topNode.getNext();
		
		return top;
	}

	/**
	 * Retrieves this stack's top entry.
	 * 
	 * @return  The object at the top of the stack.
     * @throws  EmptyStackException if the stack is empty.
	 */
	@Override
	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	}

	/**
	 * Detects whether this stack is empty.
	 * 
	 * @return  True if the stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	/**
	 * Removes all entries from this stack.
	 */
	@Override
	public void clear() {
		topNode = null;
	}
	
	/**
	 * The private inner class that directly supports
	 * the LinkedStack implementation of Stack
	 */
	private class Node {
		
		private T data;
		private Node next;
		
		/**
		 * Creates a node with specified data
		 * and pointer to the next node
		 * 
		 * @param data the data to be stored in this Node
		 * @param next the reference to the next Node
		 */
		private Node(T data, Node next) {
			setData(data);
			setNext(next);
		}
		
		public T getData() {
			return data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
	}

}
