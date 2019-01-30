package Basics;
import java.util.ArrayList;

public class App4 {
	public static void main(String[] args) {
		ArrayList<Triangle> l = new ArrayList<Triangle>();
		TriangleProcessor tp = new TriangleProcessor(); 
		
		l.add(new Triangle(10, 4));
		l.add(new Triangle(20, 14));
		l.add(new Triangle(12, 24));
		
		System.out.println(tp.searchBiggest(l));
	}
}
