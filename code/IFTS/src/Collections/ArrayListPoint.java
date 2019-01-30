package Collections;

import java.util.ArrayList;
import java.util.Collections;

import Basics.Point;

public class ArrayListPoint{

	public static void main(String[] args) {
		ArrayList<Point> l = new ArrayList<Point>();
		Point p;
		
		l.add(new Point(1, 1));
		l.add(new Point(1, 1));
		l.add(new Point(2, 3));
		l.add(new Point(4, 5));
		l.add(new Point(4, 6));
		l.add(0, new Point(7, 8));
		l.set(0, new Point(7, 9));
		
		l.remove(0);
		l.remove(new Point(4, 6));
		
		if (l.contains(new Point(4, 5))) {
			System.out.println("l contains it!");
		}
		
		Collections.sort(l);
		
		for (int i = 0; i<l.size(); i++) {
			System.out.printf("[index=%d] -> %s\n", i, l.get(i));
		}
	}
}
