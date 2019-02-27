package Examples;

import java.awt.Point;

public class Parameters {
	
	public static void main(String[] args) {
		Point p1 = new Point(0, 0); 
		Point p2 = new Point(10, 10); 
		
		System.out.println(p1);
		System.out.println(p2);
		
		move(p1, p2);
		
		System.out.println(p1);
		System.out.println(p2);
	}

	public static void swap(Point p1, Point p2){
		Point tmp = p1;
		p1 = p2;
		p2 = tmp;
	}
	
	public static void move(Point p1, Point p2){
		p1.move(20, 20);
		p2.move(30, 30);
	}
}
