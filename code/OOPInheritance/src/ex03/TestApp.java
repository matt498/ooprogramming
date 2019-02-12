package ex03;

public class TestApp {

	public static void main(String[] args) {
		Shape[] v = new Shape[4];
		v[0] = new Circle("Red", true, 2);
		v[1] = new Circle(3);
		v[2] = new Rectangle(2, 3);
		v[3] = new Square(3);

		for (Shape s : v) {
			System.out.println(s.getArea());
		}

		if (v[3] instanceof Rectangle) {
			Rectangle r = (Rectangle)v[3];
			System.out.println(r.getWidth());
		}

	}

}
