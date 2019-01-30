package ex01;

/**
 * Class representing a motor bike that have been sold (with a licence plate and limited in speed)
 * @author Nicola Bicocchi
 *
 */
public class MotorbikeSold extends Motorbike {
	/**
	 * The license plate assigned to the motor bike after being sold
	 */
	String licencePlate;
	
	/**
	 * The maximum speed the motor bike is allowed to actually run
	 */
	double maxSpeed;
	
	/**
	 * @param color
	 * @param model
	 * @param speed
	 * @param licencePlate
	 * @param maxSpeed
	 */
	public MotorbikeSold(String color, String model, double speed, String licencePlate, double maxSpeed) {
		super(color, model, speed);
		this.licencePlate = licencePlate;
		this.maxSpeed = maxSpeed;
	}
	
	public String getLicencePlate() {
		return licencePlate;
	}
	
	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	/**
	  * {@inheritDoc}
	  * Works like in the super class but limits the speed to maxSpeed
	  */
	@Override
	public void setSpeed(double speed) {
		if (antitheft == false) {
			this.speed = Math.min(speed, maxSpeed);
		}
	}

	@Override
	public String toString() {
		return "MotorbikeSold [licencePlate=" + licencePlate + ", maxSpeed=" + maxSpeed + ", color=" + color
				+ ", model=" + model + ", speed=" + speed + ", antitheft=" + antitheft + "]";
	}
}
