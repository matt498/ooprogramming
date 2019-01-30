package ex01;

/**
 * Class representing a motor bike
 * 
 * @author Nicola Bicocchi
 */
public class Motorbike {
	/**
	 * The color of the motor bike
	 */
	String color;
	
	/**
	 * The model of the motor bike
	 */
	String model;
	
	/**
	 * The current speed of the motor bike
	 */
	double speed;
	
	/**
	 * The status of the anti theft system installed on the motor bike (disabled by default)
	 */
	boolean antitheft = false;
	

	/**
	 * @param color
	 * @param model
	 * @param speed
	 */
	public Motorbike(String color, String model, double speed) {
		this.color = color;
		this.model = model;
		this.speed = speed;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed		Set the current speed of the motor bike. It works only if antitheft is disabled.
	 */
	public void setSpeed(double speed) {
		if (antitheft == false) this.speed = speed;
	}

	public boolean isAntitheft() {
		return antitheft;
	}

	public void setAntitheft(boolean antitheft) {
		this.antitheft = antitheft;
	}

	@Override
	public String toString() {
		return "Motorbike [color=" + color + ", model=" + model + ", speed=" + speed + ", antitheft=" + antitheft + "]";
	}
}
