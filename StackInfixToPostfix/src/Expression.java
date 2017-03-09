import java.util.Scanner;

/* Uses LinkedStack implementation to convert infix expressions to postfix expressions
 * and evaluates the postfix expresssions
 */
public class Expression {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String infix = "";
		
		System.out.print("Infix Expression: ");
		infix = in.nextLine();
		if(!checkBalance(infix)) // Check if parentheses are balanced
			System.out.println("Unbalanced parantheses! Please correct the expression");
		else {
			System.out.println();
			System.out.print("The equivalent postfix expression is: ");
			System.out.println(infixToPostfix(infix)); // Convert to posfix
			System.out.println("\n");
			System.out.print("The postfix expression evaluates to: ");
			System.out.println(evaluatePostfix(infixToPostfix(infix))); // Evaluate
		}
	}
	
	// Convert infix expression to postfix using Stack ADT
	public static String infixToPostfix(String infix) {
		assert checkBalance(infix); // Confirm balanced parentheses
		
		LinkedStack<String> operatorStack = new LinkedStack<>();
		Scanner in = new Scanner(infix);
		String postfix = "";
		String nextToken = "";
		
		// Add spaces in infix expression so Scanner can read easily
		infix = infix.replaceAll("\\(", " ( ");
		infix = infix.replaceAll("\\)", " ) ");
		infix = infix.replaceAll("\\{", " { ");
		infix = infix.replaceAll("\\}", " } ");
		infix = infix.replaceAll("\\[", " [ ");
		infix = infix.replaceAll("\\]", " ] ");
		infix = infix.replaceAll("\\+", " + ");
		infix = infix.replaceAll("-", " - ");
		infix = infix.replaceAll("\\*", " * ");
		infix = infix.replaceAll("/", " / ");
		infix = infix.replaceAll("%", " % ");
		infix = infix.replaceAll("\\^", " ^ ");
		
		// Read in each token and decide what to do
		Scanner spaced_in = new Scanner(infix);
		while(spaced_in.hasNext()) {
			nextToken = spaced_in.next();
			switch(nextToken) {
			case "^": case "*": case "/": case "%": case "+": case "-": // Add to operator stack based on precedence
				while(!operatorStack.isEmpty() && getPrecedence(nextToken) <= getPrecedence(operatorStack.peek())) {
					postfix += operatorStack.peek() + " ";
					operatorStack.pop();
				}
				operatorStack.push(nextToken);
				break;
			case "(": case "{": case "[":
				operatorStack.push(nextToken);
				break;
			case ")": // Add operators in stack to postfix till matching opener found 
				String topOperator = operatorStack.pop();
				while(!topOperator.equals("(") && !operatorStack.isEmpty()) {
					postfix += topOperator + " ";
					topOperator = operatorStack.pop();
				}
				break;
			case "}": // Add operators in stack to postfix till matching opener found 
				String topOperator2 = operatorStack.pop();
				while(!topOperator2.equals("{") && !operatorStack.isEmpty()) {
					postfix += topOperator2 + " ";
					topOperator2 = operatorStack.pop();
				}
				break;
			case "]": // Add operators in stack to postfix till matching opener found 
				String topOperator3 = operatorStack.pop();
				while(!topOperator3.equals("[") && !operatorStack.isEmpty()) {
					postfix += topOperator3 + " ";
					topOperator3 = operatorStack.pop();
				}
				break;
			default: postfix += nextToken + " "; // Add numbers to postfix
			}
		}
		
		// Add all left over operators to postfix
		while(!operatorStack.isEmpty()) {
			String topOperator = operatorStack.pop();
			postfix += topOperator + " ";
		}
		
		return postfix;
	}
	
	// Evaluate the postfix expression using Stack ADT
	public static int evaluatePostfix(String postfix) {
		LinkedStack<Integer> valueStack = new LinkedStack<>();
		Scanner s = new Scanner(postfix);
		String next = "";
		int op1, op2, result;
		
		while(s.hasNext()) {
			next = s.next();
			
			if(next.charAt(0) > '0' && next.charAt(0) <= '9') // Add numbers to stack
				valueStack.push(Integer.parseInt(next));
			else if(next.charAt(0) == '+') { // Add top 2 operands
					op2 = valueStack.pop();
					op1 = valueStack.pop();
					result = op1 + op2;
					valueStack.push(result);
			}
			else if(next.charAt(0) == '-') { // Subtract top 2 operands
				op2 = valueStack.pop();
				op1 = valueStack.pop();
				result = op1 - op2;
				valueStack.push(result);
			}
			else if(next.charAt(0) == '*') { // Multiply top 2 operands
				op2 = valueStack.pop();
				op1 = valueStack.pop();
				result = op1 * op2;
				valueStack.push(result);
			}
			else if(next.charAt(0) == '/') { // Divide top 2 operands
				op2 = valueStack.pop();
				op1 = valueStack.pop();
				result = op1 / op2;
				valueStack.push(result);
			}
			else if(next.charAt(0) == '%') { // Get remainder after diving top 2 operands
				op2 = valueStack.pop();
				op1 = valueStack.pop();
				result = op1 % op2;
				valueStack.push(result);
			}
			else if(next.charAt(0) == '^') { // Exponentiate top operator to 2nd from top operator
				op2 = valueStack.pop();
				op1 = valueStack.pop();
				result = (int)Math.pow(op1, op2);
				valueStack.push(result);
			}
		}
		return valueStack.peek();
	}
	
	// Verifies that parentheses (all types of brackets) are balanced
	public static boolean checkBalance(String expression) {
		LinkedStack<Character> openStack = new LinkedStack<>();
		boolean isBalanced = true;
		char nextChar = ' ';
		int charCount = expression.length();
		int index = 0;
		
		while(isBalanced && (index < charCount)) { // Iterate one character at a time
			nextChar = expression.charAt(index);
			switch(nextChar) {
			case '(': case '[': case '{':
				openStack.push(nextChar);
				break;
			case ')': case ']': case '}':
				if(openStack.isEmpty()) // Stack empty => not balanced
					isBalanced = false;
				else {
					char openDelimiter = openStack.pop();
					isBalanced = isPaired(openDelimiter, nextChar); // Find matching opener
				}
				break;
			default: break;
			}
			index++;
		}
		
		if(!openStack.isEmpty())
			isBalanced = false;
		
		return isBalanced;
	}
	
	// Checks if corresponding brackets match
	private static boolean isPaired(char open, char close) {
		return (open == '(' && close == ')') ||
				(open == '[' && close == ']') ||
				(open == '{' && close == '}');
	}
	
	// Assigns a numeric precedence to operators for stack operations
	private static int getPrecedence(String operator) {
		if(operator.equals("^"))
			return 4; // Highest precedence
		else if(operator.equals("*") || operator.equals("/") || operator.equals("%"))
			return 3;
		else if(operator.equals("+") || operator.equals("-"))
			return 2;
		else return 1; // Lowest precedence
	}

}
