import java.util.Arrays;

public class SetTester {

	public static void main(String[] args) {
		
		System.out.println("Testing implementation of ResizableArraySet: -\n");
		
		// Create new default set
		ResizableArraySet<Integer> array = new ResizableArraySet<>();
		
		// Test getSize()
		System.out.println("Created new default ResizableArraySet!\n");
		System.out.println("Testing getSize()");
		System.out.println("Expecting to see: 0");
		System.out.print("Result: ");
		System.out.println(array.getSize());
		System.out.println("Array currently holds " + Arrays.toString(array.toArray()));
		System.out.println();
		
		// Test add()
		System.out.println("Adding five items 4 9 2 5 3");
		array.add(4);
		array.add(9);
		array.add(2);
		array.add(5);
		array.add(3);
		System.out.println("Expecting to see: 4 9 2 5 3");
		System.out.print("Result: ");
		System.out.println(Arrays.toString(array.toArray()));
		System.out.println();
		
		// Test adding a duplicate
		System.out.println("Trying to add a duplicate 5");
		System.out.println("Expecting to see: fasle");
		System.out.print("Result: ");
		System.out.println(array.add(5));
		System.out.println("Array currently holds " + Arrays.toString(array.toArray()));
		System.out.println();
		
		// Test remove(T anEntry)
		System.out.println("Removing 4 and expecting to see: 3 9 2 5");
		array.remove(4);
		System.out.print("Result: ");
		System.out.println(Arrays.toString(array.toArray()));
		System.out.println();
		
		// Test remove()
		System.out.println("Removing last element by calling remove()");
		System.out.println("Expecting to see: 3 9 2");
		System.out.println("Element removed: " + array.remove());
		System.out.print("Result: ");
		System.out.println(Arrays.toString(array.toArray()));
		System.out.println();
		
		// Test contains()
		System.out.println("Checking if Set contains element '3'");
		System.out.println("Expecting to see: true");
		System.out.print("Result: ");
		System.out.println(array.contains(3));
		System.out.println("Array currently holds " + Arrays.toString(array.toArray()));
		System.out.println();
		
		// Test clear()
		System.out.println("Clearing the entire set");
		array.clear();
		System.out.println("Expecting to see: empty array");
		System.out.print("Result: ");
		System.out.println(Arrays.toString(array.toArray()));
		System.out.println();
		
		// Test isEmpty()
		System.out.println("Checking to see if array is empty by calling isEmpty()");
		System.out.println("Expecting to see: true");
		System.out.print("Result: ");
		System.out.println(array.isEmpty());
		System.out.println();
		
		System.out.println("Creating new ResizableArraySet with start size 30\n");
		
		// Test parameterized constructor and create new set for union & intersection
		ResizableArraySet<Integer> set1 = new ResizableArraySet<>(30);
		
		System.out.println("Adding five items 7 1 8 0 4");
		set1.add(7);
		set1.add(1);
		set1.add(8);
		set1.add(0);
		set1.add(4);
		System.out.println("Expecting to see: 7 1 8 0 4");
		System.out.print("Result: ");
		System.out.println(Arrays.toString(set1.toArray()));
		System.out.println();
		
		// Test union()
		System.out.println("Testing union of 7 1 8 0 4 with 2 3 8 0 6");
		System.out.println("Expecting to see: 7 1 8 0 4 2 3 6");
		// Create another set for union & intersection
		ResizableArraySet<Integer> set2 = new ResizableArraySet<>();
		ResizableArraySet<Integer> unionSet = new ResizableArraySet<>();
		set2.add(2);
		set2.add(3);
		set2.add(8);
		set2.add(0);
		set2.add(6);
		unionSet = (ResizableArraySet<Integer>)set1.union(set2);
		System.out.print("Result: ");
		System.out.println(Arrays.toString(unionSet.toArray()));
		System.out.println();
		
		// Test intersection()
		System.out.println("Testing intersection of 7 1 8 0 4 with 2 3 8 0 6");
		System.out.println("Expecting to see: 8 0");
		ResizableArraySet<Integer> intersectionSet = new ResizableArraySet<>();
		intersectionSet = (ResizableArraySet<Integer>)set1.intersection(set2);
		System.out.print("Result: ");
		System.out.println(Arrays.toString(intersectionSet.toArray()));
		System.out.println();
	}

}
