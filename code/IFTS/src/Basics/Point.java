package Basics;

public class Point implements Comparable {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(double x) {
		this.x = x;
		this.y = y;
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
	
	public boolean isInside(Rectangle r) {
		if (x >= r.getX() && 
				x <= r.getX() + r.getW() &&
				y > r.getY() &&
				y <= r.getY() + r.getH()) return true;
		return false;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		if (other.getX() == x && other.getY() == y)
			return true;
		return false;
	}

	@Override
	public int compareTo(Object o) {
		Point other = (Point) o;
		double d1 = Math.pow(x, 2) + Math.pow(y, 2);
		double d2 = Math.pow(other.getX(), 2) + Math.pow(other.getY(), 2);
		if (d1 < d2) return -1;
		if (d1 > d2) return 1;
		return 0;
	}
}
