/**
 * This class implements the Set interface using the concept of Linked Data.
 * 
 * @author Pranshu Kumar
 *
 */
public class LinkedSet<T> implements Set<T> {
	
	private Node firstNode;
	
	public LinkedSet() {
		firstNode = null;
	}

	/**
	 * Gets the current number of entries in this set.
	 * 
	 * @return The integer number of entries currently in the set.
	 */
	@Override
	public int getSize() {
		Node current = firstNode;
		int count = 0;
		
		while(current != null) {
			count++;
			current = current.next;
		}
			
		return count;
	}

	/**
	 * Sees whether this set is empty.
	 * 
	 * @return True if the set is empty, or false if not.
	 */
	@Override
	public boolean isEmpty() {
		return firstNode == null;
	}

	/**
	 * Adds a new entry to this set, avoiding duplicates.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 * 
	 * @return True if the addition is successful, or false if the item already
	 *         is in the set.
	 */
	@Override
	public boolean add(T newEntry) {
		boolean found = false;
		Node current = firstNode;
		
		while(!found && current != null) {
			if(current.data.equals(newEntry)) 
				return found;
			current = current.next;
		}
		
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		found = true;
		
		return found;
	}

	/**
	 * Removes a specific entry from this set, if possible.
	 * 
	 * @param anEntry The entry to be removed.
	 * 
	 * @return True if the removal was successful, or false if not.
	 */
	@Override
	public boolean remove(T anEntry) {
		boolean found = false;
		Node current = firstNode;
		
		while(!found && current != null) {
			if(current.data.equals(anEntry)) {
				current.data = firstNode.data;
				firstNode = firstNode.next;
				found = true;
			}
			else
				current = current.next;
		}
		
		return found;
	}

	/**
	 * Removes one unspecified entry from this set, if possible.
	 * 
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	@Override
	public T remove() {
		T result = null;
		
		if(firstNode != null) {
			result = firstNode.data;
			firstNode = firstNode.next;
		}
			
		return result;
	}

	/** Removes all entries from this set. */
	@Override
	public void clear() {
		firstNode = null;
		
	}

	/**
	 * Tests whether this set contains a given entry.
	 * 
	 * @param anEntry The entry to locate.
	 * 
	 * @return True if the set contains anEntry, or false if not.
	 */
	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node current = firstNode;
		
		while(!found && current != null) {
			if(current.data.equals(anEntry))
				found = true;
			else
				current = current.next;
		}
		
		return found;
	}

	/**
	 * Computes the union of this set with a given set
	 * 
	 * @param anotherSet Another set
	 * 
	 * @return the union of this set with anotherSet
	 */
	@Override
	public Set<T> union(Set<T> anotherSet) {
		Set<T> unionArr = new LinkedSet<T>();
		T[] tempArr = anotherSet.toArray();
		Node current = firstNode;
		
		while(current != null) {
			unionArr.add(current.data);
			current = current.next;
		}
		
		for(int count = 0; count < anotherSet.getSize(); count++) 
			unionArr.add(tempArr[count]);
		
		return unionArr;
	}

	/**
	 * Computes the intersection of this set with a given set
	 * 
	 * @param anotherSet Another set
	 * 
	 * @return the intersection of this set with anotherSet
	 */
	@Override
	public Set<T> intersection(Set<T> anotherSet) {
		Set<T> intersectionArr = new LinkedSet<T>();
		T[] arr = toArray();
		T[] tempArr = anotherSet.toArray();
		
		for(int count1 = 0; count1 < getSize(); count1++) {
			for(int count2 = 0; count2 < anotherSet.getSize(); count2++) {
				if(arr[count1].equals(tempArr[count2]))
					intersectionArr.add(arr[count1]);
			}
		}
		
		return intersectionArr;
	}

	/**
	 * Retrieves all entries that are in this set.
	 * 
	 * @return A newly allocated array of all the entries in the set, where the
	 *         size of the array is equal to the number of entries in the set.
	 */
	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[getSize()];

		int index = 0;
		Node current = firstNode;
		while (current != null) {
			result[index] = current.data;
			current = current.next;
			index++;
		}

		return result;
	}
	
	/**
	 * The private inner class that directly supports
	 * the LinkedSet implementation of Set
	 * 
	 * @author Norm Krumpe
	 *
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
			this.data = data;
			this.next = next;
		}

		/**
		 * Creates a node with specified data
		 * but sets next to null, indicating that
		 * this node does not yet refer to a next node
		 * 
		 * @param data the data to be stored in this Node
		 */
		private Node(T data) {
			this(data, null);
		}
	}

}
