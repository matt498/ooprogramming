package Car;

public class SDCar extends Car {
	private boolean isSelfDriving;
	
	public SDCar(String licensePlate, boolean isSelfDriving) {
		super(licensePlate);
		this.isSelfDriving = false;
		System.out.println("new SDCar");
	}
	
	void turnOn() {
		isSelfDriving = false;
		super.turnOn();
	}
	
	void turnOff() {
		isSelfDriving = false;
		super.turnOff();
	}

	void turnSDOn() {
		isSelfDriving = true;
	}
	
	void turnSDOff() {
		isSelfDriving = false;
	}

	@Override
	public String toString() {
		return "SDCar [isSelfDriving=" + isSelfDriving + ", isOn=" + isOn + ", licensePlate=" + licensePlate + "]";
	}
	
	
}

