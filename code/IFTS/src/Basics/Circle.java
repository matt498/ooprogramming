package Basics;

public class Circle {
	public double x;
	public double y;
	public double r;

	public Circle(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public boolean isInside(Point p) {
		double distance = Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2);
		distance = Math.sqrt(distance);

		if (distance < r) return true;
		return false;
	}

	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", r=" + r + "]";
	}
	
	
}
