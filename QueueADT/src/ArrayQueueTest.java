import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayQueueTest {

	@Test
	public void testIsEmpty() {
		QueueInterface<Integer> queue = new ArrayQueue<>();
		assertTrue(queue.isEmpty());
		queue.enqueue(10);
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void testGetFront() {
		QueueInterface<Integer> queue = new ArrayQueue<>();
		int[] data = {47, 83, 55, 99, 66, 27, 68};
		
		for (int n : data) {
			queue.enqueue(n);
			assertEquals(47, (int)queue.getFront());
		}
	
	}
	
	@Test
	public void testQueueing() {
		QueueInterface<Integer> queue = new ArrayQueue<>();
		int[] data = {47, 83, 55, 99, 66, 27, 68};
		
		for (int n : data) {
			queue.enqueue(n);
			assertFalse(queue.isEmpty());
			assertEquals(n, (int)queue.dequeue());
			assertTrue(queue.isEmpty());
		}		
		
		for (int n : data) {
			queue.enqueue(n);
		}
		for (int n : data) {
			queue.enqueue(n);
		}
		queue.dequeue();
		queue.dequeue();
		for (int n : data) {
			queue.enqueue(n);
		}
		
		
		for (int i = 2; i < data.length; i++) {
			assertEquals(data[i], (int)queue.dequeue());
		}
		for (int n : data) {
			assertEquals(n, (int)queue.dequeue());
		}		
		
		while(!queue.isEmpty()) {
			queue.dequeue();
		}		
		
		assertTrue(queue.isEmpty());		
		
	}
}
