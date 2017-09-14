import java.util.*;

/**
 * Your implementation of the Trends interface.  The only public methods
 * in this class should be the ones that implement the interface.  You
 * should write as many other private methods as needed.  Of course, you
 * should also have a public constructor.
 * 
 * @author Pranshu Kumar
 */
  

public class StudentTrends implements Trends {
	
	HashTable hashTable;
	
	public StudentTrends() {
		hashTable = new HashTable();
	}

	@Override
	public void increaseCount(String s, int amount) {
		hashTable.add(s, amount);
	}

	@Override
	public int getCount(String s) {
		return hashTable.getValue(s);
	}

	@Override
	public String getNthMostPopular(int n) {
		return hashTable.sortByValue(n);
	}

	@Override
	public int numEntries() {
		return hashTable.getNumOfUniqueEntries();
	}
	
	private class HashTable {
		
		private final static int TABLE_SIZE = 20011;
		
		private ArrayList<Node<String, Integer>> hashTable;
		private ArrayList<Node<String, Integer>> sortedList = new ArrayList<>();
		int numberOfEntries;
		
		private HashTable() {
			hashTable = new ArrayList<>();
			numberOfEntries = 0;
			
			for(int i = 0; i < TABLE_SIZE; i++)
				hashTable.add(null);
		}
		
		private int getNumOfUniqueEntries() {
			return numberOfEntries;
		}
		
		private void add(String key, int value) {
			int hashIndex = key.hashCode() % TABLE_SIZE;
			if(hashIndex < 0)
				hashIndex += TABLE_SIZE;
			
			Node<String, Integer> head = hashTable.get(hashIndex);
			
			// If key already present
			while(head != null) {
				if(head.key.equals(key)) {
					head.value += value;	// Modify the value of existing key
					return;		// Return from method (done)
				}
				head = head.next;
			}
			
			// If key doesn't already exist
			numberOfEntries++;
			hashIndex = key.hashCode() % TABLE_SIZE;
			if(hashIndex < 0)
				hashIndex += TABLE_SIZE;
			head = hashTable.get(hashIndex);
			Node<String, Integer> newNode = new Node<String, Integer>(key, value);
			newNode.next = head;
			hashTable.set(hashIndex, newNode);
			
			//sort(key, value);
		}
		
		private Integer getValue(String key) {
			int hashIndex = key.hashCode() % TABLE_SIZE;
			if(hashIndex < 0)
				hashIndex += TABLE_SIZE;
			
			Node<String, Integer> head = hashTable.get(hashIndex);
			
			while(head != null) {
				if(head.key.equals(key))
					return head.value;
				head = head.next;
			}
			return 0;
		}
		
//		private void sort(String key, int value) {		
//			Node<String, Integer> curr = new Node<String, Integer>(key, value);
//			
//			if(getValue(key) > 0) {
//				for(int i = 0; i < sortedList.size()-1; i++) {
//					if(sortedList.get(i).key.equals(key)) {
//						sortedList.get(i).value += value;
//						curr = sortedList.get(i);
//						break;
//					}
//				}
//			}
//			else {
//				sortedList.add(curr);
//				System.out.println(sortedList.get(0));
//				return;
//			}
//			
//			
//			for(int i = 0; i < sortedList.size()-1; i++) {	
//				if(curr.value > sortedList.get(i).value) {
//					sortedList.remove(curr);
//					sortedList.add(i, curr);
//					break; 
//				}
//			}
//		}
		
		private String sortByValue(int n) {
			if(n > numberOfEntries-1)
				return "Error! - Not a valid request";
			
			ArrayList<Node<String, Integer>> sorted = new ArrayList<>();
			ArrayList<Node<String, Integer>> rev = new ArrayList<>();
			int i = 0;
			
			for(Node<String, Integer> node : hashTable) {
				Node<String, Integer> head = node;
				while(head != null) {
					sorted.add(i++, head);
					head = head.next;
				}
			}
			
			quickSort(sorted, 0, sorted.toArray().length-1); // !!! Work on speed
			
			for(int k = sorted.size()-1; k >= 0; k--)
				rev.add(sorted.remove(k));			// !!! Try to avoid this
			
			return rev.get(n).key;
		}
		
		private void quickSort(ArrayList<Node<String, Integer>> arr, int low, int high) {
			if (arr == null || arr.size() == 0)
				return;
	 
			if (low >= high)	// !!! Somehow work to directly sort in desc order
				return;
	 
			// pick the pivot
			int middle = low + (high - low) / 2;
			int pivot = arr.get(middle).value;
	 
			// make left < pivot and right > pivot
			int i = low, j = high;
			while (i <= j) {
				while (arr.get(i).value < pivot)
					i++;
	 
				while (arr.get(j).value > pivot)
					j--;
	 
				if (i <= j) {
					Node<String, Integer> temp = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
					i++;
					j--;
				}
			}
	 
			// recursively sort two sub parts
			if (low < j)
				quickSort(arr, low, j);
	 
			if (high > i)
				quickSort(arr, i, high);
		}
		
		private class Node<String, Integer> {
			private String key;
			private Integer value;
			private Node<String, Integer> next;

			/**
			 * Creates a node with specified data
			 * and pointer to the next node
			 * 
			 * @param key the String key
			 * @param value the int value
			 * @param next the reference to the next Node
			 */
			private Node(String key, Integer value, Node<String, Integer> next) {
				this.key = key;
				this.value = value;
				this.next = next;
			}

			/**
			 * Creates a node with specified key-value pair
			 * but sets next to null, indicating that
			 * this node does not yet refer to a next node
			 * 
			 * @param key the String key
			 * @param value the int value
			 */
			private Node(String key, Integer value) {
				this(key, value, null);
			}
		}
	}
    
}
