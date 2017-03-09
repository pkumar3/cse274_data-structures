/**
 * This class implements the Set interface and uses an array to make it resizable
 * 
 * @author Pranshu Kumar
 *
 */
public class ResizableArraySet<T> implements Set<T>{

	private T[] arr;
	private int numberOfEntries;
	private final static int DEFAULT_CAPACITY = 10;
	
	/**
	 * Default Constructor
	 */
	public ResizableArraySet() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Parameterized Constructor
	 * 
	 * @param startSize The size to initialize the set with
	 */
	public ResizableArraySet(int startSize) {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[startSize];
		arr = temp;
		numberOfEntries = 0;
	}
	
	/**
	 * Gets the current number of entries in this set.
	 * 
	 * @return The integer number of entries currently in the set.
	 */
	@Override
	public int getSize() {
		return numberOfEntries;
	}

	/**
	 * Sees whether this set is empty.
	 * 
	 * @return True if the set is empty, or false if not.
	 */
	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
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
		boolean success = false;
		
		for(int count = 0; count < numberOfEntries; count++) {
			if(arr[count].equals(newEntry))
				return success;
		}
		
		if(numberOfEntries == arr.length) {
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[numberOfEntries*2];
			for(int count = 0; count < numberOfEntries; count++)
				temp[count] = arr[count];
			arr = temp;
		}
		
		arr[numberOfEntries] = newEntry;
		numberOfEntries++;
		success = true;
			
		return success;
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
		if(numberOfEntries == 0)
			return false;
		
		for(int i = 0; i < numberOfEntries; i++) {
			if(arr[i].equals(anEntry)) {
				arr[i] = arr[numberOfEntries-1];
				arr[numberOfEntries] = null;
				numberOfEntries--;
				
				if(numberOfEntries < arr.length/2) {
					@SuppressWarnings("unchecked")
					T[] temp = (T[]) new Object[arr.length/2];
					for(int count = 0; count < numberOfEntries; count++)
						temp[count] = arr[count];
					arr = temp;
				}
				
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes one unspecified entry from this set, if possible.
	 * 
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	@Override
	public T remove() {
		if(numberOfEntries == 0)
			return null;
		
		T removed = arr[numberOfEntries-1];
		arr[numberOfEntries-1] = null;
		numberOfEntries--;
		
		if(numberOfEntries < arr.length/2) {
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[arr.length/2];
			for(int count = 0; count < numberOfEntries; count++)
				temp[count] = arr[count];
			arr = temp;
		}
		
		return removed;
	}

	/** Removes all entries from this set. */
	@Override
	public void clear() {
		for(int i = 0; i < numberOfEntries; i++)
			arr[i] = null;
		
		numberOfEntries = 0;
		
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
		for(int count = 0; count < numberOfEntries; count++) {
			if(arr[count].equals(anEntry))
				return true;
		}
		return false;
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
		Set<T> unionArr = new ResizableArraySet<T>();
		T[] tempArr = anotherSet.toArray();
		
		for(int count = 0; count < numberOfEntries; count++) 
			unionArr.add(arr[count]);
		
		
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
		Set<T> intersectionArr = new ResizableArraySet<T>();
		T[] tempArr = anotherSet.toArray();
		
		for(int count1 = 0; count1 < numberOfEntries; count1++) {
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
		T[] newArr;
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[numberOfEntries];
		for(int count = 0; count < numberOfEntries; count++)
			temp[count] = arr[count];
		
		newArr = temp;
		
		return newArr;
	}

}
