package ex04;

public class TestApp {

	public static void main(String[] args) {
		MovableRectangle r = new MovableRectangle(0, 10, 20, 0, 1, 1);
		System.out.println(r);
		r.moveRight();
		System.out.println(r);

	}

}
