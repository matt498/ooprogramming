package Basics;
public class App2 {
	public static void main(String[] args) {
		Person[] v = new Person[16];
		
		v[0] = new Person("Nicola", "Bicocchi", 38);
		v[1] = new Person("Luca", "Bicocchi", 38);
		v[2] = new Person("Mario", "Bianchi", 48);
		
		for (Person p : v) {
			if (p.getName().equals("Nicola")) {
				System.out.println(p);
			}
		}

	}
}
