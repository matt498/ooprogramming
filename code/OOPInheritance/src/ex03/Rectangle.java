package ex03;

public class Rectangle extends Shape {
	protected double width;
	protected double heigth;
	
	public Rectangle() {
		super();
		this.width = 10;
		this.heigth = 10;
	}	
	
	public Rectangle(double width, double heigth) {
		super();
		this.width = width;
		this.heigth = heigth;
	}
	
	public Rectangle(String color, boolean filled, double width, double heigth) {
		super(color, filled);
		this.width = width;
		this.heigth = heigth;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	@Override
	public double getArea() {
		return width * heigth;
	}

	@Override
	public double getPerimeter() {
		return (width + heigth) * 2;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", heigth=" + heigth + ", color=" + color + ", filled=" + filled + "]";
	}
}
