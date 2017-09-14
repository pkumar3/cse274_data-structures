import java.util.Arrays;

/**
 * A simple maxheap class using int values, implemented with an array
 * with an empty spot at 0 for convenience
 * 
 * @author Pranshu Kumar
 *
 */
public class MaxHeap {
	private int[] heap;
	private int lastIndex;
	private static int DEFAULT_CAPACITY = 10;
	
	public MaxHeap() {
		heap = new int[DEFAULT_CAPACITY];
		lastIndex = 0;
	}
	
	/**
	 * Adds an element to the heap by
	 * 	1) Putting in the next available spot in the array
	 * 	2) Bubbling it up until we fin a parent who is bigger, or reach the root
	 * 
	 * @param n An ineger
	 */
	public void add(int n) {
		checkCapacity();
		
		lastIndex++;
		heap[lastIndex] = n;
		
		int childIndex = lastIndex;
		int parentIndex = childIndex / 2;
		
		while(parentIndex > 0 && heap[childIndex] > heap[parentIndex]) {
			int temp = heap[childIndex];
			heap[childIndex] = heap[parentIndex];
			heap[parentIndex] = temp;
			
			childIndex = parentIndex;
			parentIndex = childIndex/2;
		}
	}
	
	/**
	 * Returns the largest value of the MaxHeap
	 * 	1) Save value from heap[1] to return at the end
	 * 	2) Put the last node value into heap[1], and reduce lastIndex
	 * 	3) "Reheap" by moving the root value down until its largest child is smaller
	 * 
	 * @return largest value (found at top of MaxHeap)
	 */
	public int removeMax() {	
		int result = heap[1];
		
		heap[1] = heap[lastIndex];
		lastIndex--;
		reheap(1);
		
		return result;
	}
	
	/**
	 * Transforms a semiheap into a heap
	 * 
	 * @param rootIndex The index of the root
	 */
	private void reheap(int rootIndex) {
		boolean done = false;
		int orphan = heap[rootIndex];
		int leftChildIndex = 2*rootIndex;
		
		while(!done && (leftChildIndex <= lastIndex)) {
			int largerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;
			if((rightChildIndex <= lastIndex) && 
						heap[rightChildIndex] > heap[largerChildIndex])
				largerChildIndex = rightChildIndex;
			if(orphan < heap[largerChildIndex]) {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2*rootIndex;
			}
			else
				done = true;
		}
		heap[rootIndex] = orphan;
	}
	
	/**
	 * Resize the array if it's full
	 */
	private void checkCapacity() {
		if(lastIndex+1 == heap.length)
			heap = Arrays.copyOf(heap, 2*heap.length);
	}
	
	/**
	 * Returns an array with only the elements in it
	 * 
	 * @return A copy of the array 'heap'
	 */
	public int[] toArray() {
		return Arrays.copyOf(heap, lastIndex+1);
	}
}
