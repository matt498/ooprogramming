package Ereditarieta;

public abstract class Shape implements Areable {
	double x;
	double y;
	String color;
	
	public Shape(double x, double y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
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
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
}
