package Car;

public class ECar extends SDCar {
	boolean isCharged;

	public ECar(String licensePlate, 
			boolean isSelfDriving,
			boolean isCharged) {
		super(licensePlate, isSelfDriving);
		this.isCharged = isCharged;
		System.out.println("new ECar");
	}

	@Override
	public String toString() {
		return "ECar [isCharged=" + isCharged + ", isOn=" + isOn + ", licensePlate=" + licensePlate + "]";
	}
	
	

}
