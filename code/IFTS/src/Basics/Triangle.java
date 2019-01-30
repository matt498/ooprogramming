package Basics;

public class Triangle {
	protected double b, h;

	public Triangle(double b, double h) {
		this.b = b;
		this.h = h;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}
	
	public double getArea() {
		return b * h / 2;
	}

	@Override
	public String toString() {
		return "Triangle [b=" + b + ", h=" + h + ", a=" + getArea() + "]";
	}
	
	
	
	

}
