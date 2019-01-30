package Basics;
import java.util.ArrayList;

public class TriangleProcessor {
	public Triangle searchBiggest(ArrayList<Triangle> l) {
		
		Triangle tmax = null;
		double amax = 0;
		for (Triangle t : l) {
			if (t.getArea() > amax) {
				amax = t.getArea();
				tmax = t;
			}
		}
		return tmax;
	}
}
