/**
 * An interface that describes the operations of a set of objects.  Created by Carrano, Henry, Hoot.
 * Modified by Norm Krumpe
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author Charles Hoot
 * @version 5.0
 */
public interface Set<T> {
	/**
	 * Gets the current number of entries in this set.
	 * 
	 * @return The integer number of entries currently in the set.
	 */
	public int getSize();

	/**
	 * Sees whether this set is empty.
	 * 
	 * @return True if the set is empty, or false if not.
	 */
	public boolean isEmpty();

	/**
	 * Adds a new entry to this set, avoiding duplicates.
	 * 
	 * @param newEntry
	 *            The object to be added as a new entry.
	 * @return True if the addition is successful, or false if the item already
	 *         is in the set.
	 */
	public boolean add(T newEntry);

	/**
	 * Removes a specific entry from this set, if possible.
	 * 
	 * @param anEntry
	 *            The entry to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	public boolean remove(T anEntry);

	/**
	 * Removes one unspecified entry from this set, if possible.
	 * 
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	public T remove();

	/** Removes all entries from this set. */
	public void clear();

	/**
	 * Tests whether this set contains a given entry.
	 * 
	 * @param anEntry
	 *            The entry to locate.
	 * @return True if the set contains anEntry, or false if not.
	 */
	public boolean contains(T anEntry);

	/**
	 * Computes the union of this set with a given set
	 * 
	 * @param anotherSet
	 *            another set
	 * @return the union of this set with anotherSet
	 */
	public Set<T> union(Set<T> anotherSet);
	
	/**
	 * Computes the intersection of this set with a given set
	 * 
	 * @param anotherSet
	 *            another set
	 * @return the intersection of this set with anotherSet
	 */
	public Set<T> intersection(Set<T> anotherSet);

	/**
	 * Retrieves all entries that are in this set.
	 * 
	 * @return A newly allocated array of all the entries in the set, where the
	 *         size of the array is equal to the number of entries in the set.
	 */
	public T[] toArray();
} // end SetInterface
