package Car;

public class TestApp {
	public static void main(String[] args) {
		Car[] garage = new Car[4];
		garage[0] = new Car("AA456YY");
		garage[1] = new SDCar("TT543EE", false);
		garage[2] = new SDCar("UU765WW", false);
		garage[3] = new ECar("OO765EE", false, false);
		
		for (Car c : garage) {
			System.out.println(c.toString());
		}
		
		
	}

}
