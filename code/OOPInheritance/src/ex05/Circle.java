package ex05;

public class Circle implements GeometricObject {
	protected double radius  = 1.0;
	
	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.pow(radius, 2) * Math.PI;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
}
