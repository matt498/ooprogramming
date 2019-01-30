package Collections;

import java.util.ArrayList;
import java.util.Iterator;

import Basics.Person;

public class IteratorExample {
	public static void main(String[] args) {
		ArrayList<Person> l = new ArrayList<Person>();
		l.add(new Person("Nicola", "Bicocchi", 38));
		l.add(new Person("Luca", "Bianchi", 38));
		l.add(new Person("Mario", "Verdi", 38));
		
		for (Iterator<Person> i = l.iterator(); i.hasNext(); ) {
			Person p = i.next();
			if (p.getName().equals("Nicola")) {
				i.remove();
			}
		}
		
		Iterator<Person> i = l.iterator();
		while (i.hasNext()) {
			Person p = i.next();
		}
		System.out.println(l);
	}
}
