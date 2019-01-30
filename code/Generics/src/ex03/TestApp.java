package ex03;

import ex02.Student;

/**
 * Data l'implementazione semplificata di LinkedList 
 * (package Collections->InternalImplementations->MyLinkedList),
 * renderla generica (myLinkedList<T>)in modo da applicarsi al caso seguente.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	
	public static void main(String[] args) {
		MyLinkedList<Student> l = new MyLinkedList<Student>();
		l.add(new Student("Nicola", "Bicocchi"));
		l.add(new Student("Lucia", "Rossi"));
		l.add(new Student("Maccio", "Capatonda"));

		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}
}