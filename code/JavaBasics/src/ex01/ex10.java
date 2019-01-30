package ex01;

public class ex10 {	
	public static void main(String[] args) {
		Point p1 = new Point(0, 0);
		CircleBasic c1 = new CircleBasic(0, 0, 1);

		double distance = Math.pow(p1.getX() - c1.getX(), 2) + Math.pow(p1.getY() - c1.getY(), 2);
		distance = Math.sqrt(distance);

		if (distance < c1.getR()) {
			System.out.println("The point is inside!");
		} else {
			System.out.println("The point is outside!");	
		}
	}
}
