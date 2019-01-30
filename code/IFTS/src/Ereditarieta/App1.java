package Ereditarieta;

public class App1 {
	public static void main(String[] args) {		
		Car[] v = new Car[3];
		v[0] = new Car("BMW", "M3");
		v[1] = new ECar("Tesla", "ModelX", 0.8);
		v[2] = new Car("Fiat", "Punto");
		
		for (Car c : v) {
			System.out.println(c);
		}
	}
}
