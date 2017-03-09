import java.util.Arrays;

public class SetTester {

	public static void main(String[] args) {
		
		System.out.println("Testing implementation of LinkedSet: -\n");
		
		// Create new default set
		LinkedSet<Integer> set1 = new LinkedSet<>();
		
		// Test getSize()
		System.out.println("Created new default LinkedSet!\n");
		System.out.println("Testing getSize()");
		System.out.println("Expecting to see: 0");
		System.out.print("Result: ");
		System.out.println(set1.getSize());
		System.out.println("set1 currently holds " + Arrays.toString(set1.toArray()));
		System.out.println();

		// Test add()
		System.out.println("Adding five items 4 9 2 5 3");
		set1.add(4);
		set1.add(9);
		set1.add(2);
		set1.add(5);
		set1.add(3);
		System.out.println("Expecting to see: 3 5 2 9 4 (new elements added to beginning)");
		System.out.print("Result: ");
		System.out.println(Arrays.toString(set1.toArray()));
		System.out.println();
		
		// Test adding a duplicate
		System.out.println("Trying to add a duplicate 5");
		System.out.println("Expecting to see: fasle");
		System.out.print("Result: ");
		System.out.println(set1.add(5));
		System.out.println("Array currently holds " + Arrays.toString(set1.toArray()));
		System.out.println();
		
		// Test remove(T anEntry)
		System.out.println("Removing 4 and expecting to see: 5 2 9 3");
		set1.remove(4);
		System.out.print("Result: ");
		System.out.println(Arrays.toString(set1.toArray()));
		System.out.println("(Element to be removed swapped with 1st element, which is then removed)");
		System.out.println();
		
		// Test remove()
		System.out.println("Removing first element by calling remove()");
		System.out.println("Expecting to see: 2 9 3");
		set1.remove();
		System.out.print("Result: ");
		System.out.println(Arrays.toString(set1.toArray()));
		System.out.println();
		
		// Test contains()
		System.out.println("Checking if Set contains element '3'");
		System.out.println("Expecting to see: true");
		System.out.print("Result: ");
		System.out.println(set1.contains(3));
		System.out.println("Array currently holds " + Arrays.toString(set1.toArray()));
		System.out.println();
		
		// Test clear()
		System.out.println("Clearing the entire set");
		set1.clear();
		System.out.println("Expecting to see: empty array");
		System.out.print("Result: ");
		System.out.println(Arrays.toString(set1.toArray()));
		System.out.println();
		
		// Test isEmpty()
		System.out.println("Checking to see if array is empty by calling isEmpty()");
		System.out.println("Expecting to see: true");
		System.out.print("Result: ");
		System.out.println(set1.isEmpty());
		System.out.println();
		
		// Add 5 items to test union() and intersection()
		System.out.println("Adding five items 7 1 8 0 4");
		set1.add(7);
		set1.add(1);
		set1.add(8);
		set1.add(0);
		set1.add(4);
		System.out.println("Expecting to see: 4 0 8 1 7");
		System.out.print("Result: ");
		System.out.println(Arrays.toString(set1.toArray()));
		System.out.println();
		
		// Test union()
		System.out.println("Testing union of 4 0 8 1 7 with 6 0 8 3 2");
		System.out.println("Expecting to see: 2 3 6 7 1 8 0 4");
		// Create another set for union & intersection
		LinkedSet<Integer> set2 = new LinkedSet<>();
		LinkedSet<Integer> unionSet = new LinkedSet<>();
		set2.add(2);
		set2.add(3);
		set2.add(8);
		set2.add(0);
		set2.add(6);
		unionSet = (LinkedSet<Integer>)set1.union(set2);
		System.out.print("Result: ");
		System.out.println(Arrays.toString(unionSet.toArray()));
		System.out.println();
		
		// Test intersection()
		System.out.println("Testing intersection of 4 0 8 1 7 with 6 0 8 3 2");
		System.out.println("Expecting to see: 8 0");
		LinkedSet<Integer> intersectionSet = new LinkedSet<>();
		intersectionSet = (LinkedSet<Integer>)set1.intersection(set2);
		System.out.print("Result: ");
		System.out.println(Arrays.toString(intersectionSet.toArray()));
		System.out.println();

	}

}
