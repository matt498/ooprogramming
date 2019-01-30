package PhoneBook;
import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBookHashMap implements PhoneBook {
	HashMap<String, Worker> m;

	public PhoneBookHashMap() {
		m = new HashMap<String, Worker>();
	}
	
	public void addPerson(Worker p) {
		m.put(p.getName(), p);
	}
	
	public void removePerson(Worker p) {
		m.remove(p.getName());
	}
	
	public Worker searchByName(String name) {
		return m.get(name);
	}
	
	public boolean modifyPerson(Worker p1, Worker p2) {
		m.put(p1.getName(), p2);
		return true;
	}

	@Override
	public String toString() {
		return m.toString();
	}
}
