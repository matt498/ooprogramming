package PhoneBook;
import java.util.ArrayList;

public class PhoneBookArrayList implements PhoneBook {
	ArrayList<Worker> l;

	public PhoneBookArrayList() {
		l = new ArrayList<Worker>();
	}
	
	public void addPerson(Worker p) {
		l.add(p);
	}
	
	public void removePerson(Worker p) {
		l.remove(p);
	}
	
	public Worker searchByName(String name) {
		for (Worker p : l) {
			if (p.getName().equals(name))
				return p;
		}
		return null;
	}
	
	public boolean modifyPerson(Worker p1, Worker p2) {
		int index = l.indexOf(p1);
		if (index == -1) 
			return false;
		l.set(index, p2);
		return true;
	}

	@Override
	public String toString() {
		return l.toString();
	}
}
