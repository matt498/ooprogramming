package SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;

public class TestBinarySearch {
	public static void main(String[] args) {
		ArrayList<Student> l = new ArrayList<Student>();
		l.add(new Student("Nicola", "Rossi", 28));
		l.add(new Student("Paolo", "Rossi", 25));
		l.add(new Student("Nicola", "Magri", 23));
		
		// sorting using natural ordering
		// defined within the Student class
		Collections.sort(l);
		
		for (Student s : l) {
			System.out.println(s);
		}

		// binary search return the index of the list containing the element
		int index;
		index = Collections.binarySearch(l, new Student("Paolo", "Rossi", 25));
		System.out.println("Found at index: " + index);
		System.out.println(l.get(index));
	}

}