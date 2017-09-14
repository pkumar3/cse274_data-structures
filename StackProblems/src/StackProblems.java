import java.util.Stack;

public class StackProblems {

	public static void main(String[] args) {
		int[] nums = {4, 1, 2, 2, 7, 2, 8, 8, 8, 4};
		Stack<Integer> stack = new Stack<>();
		
		for(int num : nums)
			stack.push(num);
		
		System.out.println(sumSkipDuplicates(stack));
		
	}

	/*
	 * Computes the sum of all the numbers in the stack
	 */
	public static int sum(Stack<Integer> data) {
		int sum = 0;
		
		while(!data.isEmpty())
			sum += data.pop();
		
		return sum;
	}

	/*
	 * Computes the sum of all the numbers in the stack. However, if two or more
	 * numbers in a row are equal, only add one of them. So, for example, if the
	 * stack contained 4, 1, 2, 2, 7, 2, 8, 8, 8, 4, then the numbers that would
	 * be added would be 4 + 1 + 2 + 7 + 2 + 8 + 4 = 28
	 */
	public static int sumSkipDuplicates(Stack<Integer> data) {
		int sum = 0;
		int prev = 0;
		
		while(!data.isEmpty()) {
			prev = data.peek();
			sum += data.pop();
			
			while(!data.isEmpty() && data.peek() == prev) 
				data.pop();
			
		}
			
		return sum;
	}

	/*
	 * Puts all of the characters of a string into a stack, with the first
	 * character of the string at the bottom of the stack and the last character
	 * of the string at the top of the stack.
	 */
	public static Stack<Character> stringToStack(String s) {
		Stack<Character> charStack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++)
			charStack.push(s.charAt(i));
		
		return charStack;

	}

	/*
	 * Reverses a given stack, so that the top of the stack becomes the bottom
	 * and the bottom becomes the top.
	 */
	public static void reverseStack(Stack<Integer> s) {
		Stack<Integer> tempStack = new Stack<>();
		Stack<Integer> rev = new Stack<>();
		
		while(!s.isEmpty())
			tempStack.push(s.pop());
		
		while(!tempStack.isEmpty())
			rev.push(tempStack.pop());
		
		while(!rev.isEmpty())
			s.push(rev.pop());
		
	}

	/*
	 * A palindrome reads the same forward and backward. Use a stack to
	 * determine if a given string is a palindrome. Challenge: try not to use
	 * any additional variables (except a counter for any loop). Just the given
	 * string and a stack of Characters.
	 */
	public static boolean isPalindrome(String s) {
		Stack<Character> charStack = stringToStack(s);
		
		for(int i = 0; i < s.length(); i++) {
			if(charStack.pop() != s.charAt(i))
				return false;
		}
		
		return true;
	}

}
