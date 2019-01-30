package ex01;


/**
 * Write a Java class representing a Circle (x, y, r). Inside the class, define 
 * a static attribute representing PI. 
 * Create two objects, c1 and c2, of class Circle.
 * 
 * Verify what happens when PI is accessed  as a class attribute or, instead, 
 * as an instance attribute (using c1 or c2). What happens when an instance (e.g., c1)
 * modifies the value of PI? What happens when PI is defined final?
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		Circle c1 = new Circle(2, 2, 4);
		Circle c2 = new Circle(2, 2, 4);
		
		System.out.println(c1.PI);
		System.out.println(c2.PI);
		
		Circle.PI = 4;
		System.out.println(c1.PI);
		System.out.println(c2.PI);
		
		c1.PI = 3;
		System.out.println(c1.PI);
		System.out.println(c2.PI);
	}
}
