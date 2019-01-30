package ex01;

/**
 * Class for testing
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		Motorbike m1 = new Motorbike("Grigio", "Liberty", 40.5);
		MotorbikeSold m2 = new MotorbikeSold("Rosso", "Scarabeo", 30.5, "CV1234", 60.0);
		
		System.out.println(m1);
		System.out.println(m2);
		
		m1.setSpeed(50);
		m2.setSpeed(60);
		
		System.out.println(m1);
		System.out.println(m2);
	}
}
