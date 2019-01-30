package Ereditarieta;

public class Triangle extends Shape {
	int nSides;
	double base, heigth;

	public Triangle(double x, double y, String color, int nSides, double base, double heigth) {
		super(x, y, color);
		this.nSides = nSides;
		this.base = base;
		this.heigth = heigth;
	}
	
	@Override
	public double getArea() {
		return base * heigth / 2;
	}

	@Override
	public String toString() {
		return "Triangle [nSides=" + nSides + ", base=" + base + ", heigth=" + heigth + ", x=" + x + ", y=" + y
				+ ", color=" + color + "]";
	}	
}
