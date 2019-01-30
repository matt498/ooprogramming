package Basics;
import java.util.ArrayList;

public class App3 {
	public static void main(String[] args) {
		ArrayList<Person> l = new ArrayList<Person>();
		
		l.add(new Person("Nicola", "Bicocchi", 38));
		l.add(new Person("Luca", "Bicocchi", 38));
		l.add(new Person("Mario", "Bianchi", 48));
		
		for(int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}

	}
}
