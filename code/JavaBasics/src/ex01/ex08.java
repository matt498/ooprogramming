package ex01;

public class ex08 {	
	public static void main(String[] args) {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(1, 1);
		
		double distance = Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2);
		distance = Math.sqrt(distance);
		
		System.out.println(distance);
	}
}
