import java.awt.Point;

public class Driver {

	public static void main(String[] args) {
		
		QueueInterface<Point> q = new ArrayQueue<>();
		
		q.enqueue(new Point(1,2)); // First in
		q.enqueue(new Point(3,4));
		q.enqueue(new Point());
		System.out.println(q.getSize());
		
		System.out.println(q.getFront());
		
		while(!q.isEmpty()) {
			Point p = q.dequeue();
			System.out.println(p);
		}
	}

}
