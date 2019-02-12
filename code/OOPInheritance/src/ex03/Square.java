package ex03;

public class Square extends Rectangle {
	public Square() {
		super();
	}
	
	public Square(double side) {
		super(side, side);
	}
	
	public Square(String color, boolean filled, double side) {
		super(color, filled, side, side);
	}
	
	public double getSide() {
		return width;
	}
	
	public void setSide(double side) {
		setWidth(side);
		setHeigth(side);
	}
	
	public void setWidth(double side) {
		setSide(side);
	}

	public void setHeigth(double side) {
		setSide(side);
	}

	@Override
	public String toString() {
		return "Square [width=" + width + ", heigth=" + heigth + ", color=" + color + ", filled=" + filled + "]";
	}
}
