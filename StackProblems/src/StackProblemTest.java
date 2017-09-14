import static org.junit.Assert.*;
import java.util.Stack;

import org.junit.Test;

public class StackProblemTest {

	@Test
	public void testSum() {
		Stack<Integer> nums = new Stack<>();
		assertEquals(0, StackProblems.sum(nums));
		
		int randomSize = 50 + (int)(20 * Math.random());
		int sum = 0;
		
		for (int i = 0; i < randomSize; i++) {
			int num = (int)(25 * Math.random());
			sum += num;
			nums.push(num);
		}
		
		assertEquals(sum, StackProblems.sum(nums));
		assertEquals(0, nums.size());
	}
	
	@Test
	public void testSumSkipDuplicates() {
		int[] data = {4, 1, 2, 2, 7, 2, 8, 8, 8, 4};
		Stack<Integer> stack = new Stack<>();
		for (int num : data) {
			stack.push(num);
		}		
		assertEquals(28, StackProblems.sumSkipDuplicates(stack));
		
		data = new int[] {1, 2, 3, 4, 5, 6};
		stack = new Stack<>();
		for (int num : data) {
			stack.push(num);
		}		
		assertEquals(21, StackProblems.sumSkipDuplicates(stack));
		
		data = new int[] {1, 1, 1, 1, 1};
		stack = new Stack<>();
		for (int num : data) {
			stack.push(num);
		}		
		assertEquals(1, StackProblems.sumSkipDuplicates(stack));
		
		data = new int[] {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6};
		stack = new Stack<>();
		for (int num : data) {
			stack.push(num);
		}		
		assertEquals(21, StackProblems.sumSkipDuplicates(stack));
		
		data = new int[] {};
		stack = new Stack<>();
		for (int num : data) {
			stack.push(num);
		}		
		assertEquals(0, StackProblems.sumSkipDuplicates(stack));
		
	}
	
	@Test
	public void testStringToStack() {
		String testString = "This is a test string.";
		Stack<Character> result = StackProblems.stringToStack(testString);
		
		String resultString = "";
		while (!result.isEmpty()) {
			resultString = result.pop() + resultString;
		}
		
		assertEquals(testString, resultString);				
	}
	
	@Test
	public void testEmptyStringToStack() {
		String testString = "";
		Stack<Character> result = StackProblems.stringToStack(testString);
		assertEquals(0, result.size());
	}
	
	@Test
	public void testReverseStack() {
		int[] data = new int[50];		
		for (int i = 0; i < data.length; i++) {
			data[i] = (int)(10 * Math.random());
		}		
		
		Stack<Integer> start = new Stack<>();			
		for (int num : data) {
			start.push(num);
		}

		StackProblems.reverseStack(start);

		for (int num : data) {
			assertEquals(num, (int)start.pop());
		}
		
		assertEquals(0, start.size());
		
	}
	
	@Test
	public void testIsPalindrome() {
		assertTrue(StackProblems.isPalindrome("a"));
		assertTrue(StackProblems.isPalindrome("BB"));
		assertTrue(StackProblems.isPalindrome("CCC"));
		assertTrue(StackProblems.isPalindrome("radar"));
		assertTrue(StackProblems.isPalindrome("racecar"));
		assertTrue(StackProblems.isPalindrome("tattarrattat"));
		
		assertFalse(StackProblems.isPalindrome("ab"));
		assertFalse(StackProblems.isPalindrome("abab"));
		assertFalse(StackProblems.isPalindrome("baaa"));		
	}
	
	

}
