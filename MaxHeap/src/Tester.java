import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		
		MaxHeap mh = new MaxHeap();
		
		for(int i = 1; i <= 10; i++) {
			int val = (int)(Math.random()*50);
			mh.add(val);
		}
		
		System.out.println(Arrays.toString(mh.toArray()));
		System.out.println(mh.removeMax());
		System.out.println(Arrays.toString(mh.toArray()));

	}

}
