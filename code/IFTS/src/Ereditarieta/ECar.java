package Ereditarieta;
public class ECar extends Car {
	protected double batteryState;
	
	public ECar(String brand, String model, double BatteryState) {
		super(brand, model);
		this.batteryState = batteryState;
	}
	
	public double getBattery() {
		return batteryState;
	}
	
	public void hello() {
		System.out.println("This is a Ecar!");
	}

	@Override
	public String toString() {
		return "ECar [batteryState=" + batteryState + ", brand=" + brand + ", model=" + model + "]";
	}
}
