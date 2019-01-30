package Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Basics.Person;

public class ArrayListPerson{
	public static void main(String[] args) {
		List<Person> l = new LinkedList<Person>();
		l.add(new Person("Nicola", "Bicocchi", 38));
		l.add(new Person("Luisa", "Lodi", 28));
		l.add(new Person("Luisa", "Lacca", 28));
		l.add(new Person("Zarla", "Lucca", 26));
		
		if (l.contains(new Person("Nicola", "Bicocchi", 38))) {
			System.out.println("Yes!");
		}
		
		Collections.sort(l, new AlternativeSorter());
		
		for (Person p : l) {
			System.out.println(p);
		}
	}
}
