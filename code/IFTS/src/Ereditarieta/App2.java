package Ereditarieta;

public class App2 {
	public static void main(String[] args) {		
		Shape[] v = new Shape[3];
		v[0] = new Triangle(0,0,"Black",3,10,10);
		v[1] = new Square(0,0,"Yellow",4,20);
		v[2] = new Square(0,0,"Red",4,20);
		
		for (Shape s : v) {
			System.out.println(s.getArea());
		}
	}
}
