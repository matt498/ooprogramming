package Ereditarieta;

public class Car {
	protected String brand;
	protected String model;
	
	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + "]";
	}
}
