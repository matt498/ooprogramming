package ex02;


/**
 * Write a Java class MyMath implementing a simple math library. In particular, 
 * MyMath must have 4 static methods implementing the 4 operations (add, subtract,
 * multiply, divide). Implement another class, MyMathNS, with the same methods but 
 * NOT static. What changes?
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		System.out.println(MyMath.PI);
		System.out.println(MyMath.add(3, 4));
		System.out.println(MyMath.subtract(3, 4));
		System.out.println(MyMath.multiply(3, 4));
		System.out.println(MyMath.divide(3, 4));
		
		MyMathNS m = new MyMathNS();
		System.out.println(MyMathNS.PI);
		System.out.println(m.add(3, 4));
		System.out.println(m.subtract(3, 4));
		System.out.println(m.multiply(3, 4));
		System.out.println(m.divide(3, 4));
	}
}
