package Ereditarieta;

public class Square extends Shape {
	int nSides;
	double side;

	public Square(double x, double y, String color, int nSides, int side) {
		super(x, y, color);
		this.nSides = nSides;
		this.side = side;
	}
	
	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public String toString() {
		return "Square [nSides=" + nSides + ", side=" + side + ", x=" + x + ", y=" + y + ", color=" + color + "]";
	}
	
	
}
