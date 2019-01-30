package Car;

public class Car {
	boolean isOn;
	String licensePlate;
	
	public Car() {
		this.isOn = false;
	}
	
	public Car(String licensePlate) {
		this.licensePlate = licensePlate;
		this.isOn = false;
		System.out.println("new Car");
	}
	
	void turnOn() {
		isOn = true;
	}
	void turnOff() {
		isOn = false;
	}

	@Override
	public String toString() {
		return "Car [isOn=" + isOn + ", licensePlate=" + licensePlate + "]";
	}


}

