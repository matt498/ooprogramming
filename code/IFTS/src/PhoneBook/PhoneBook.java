package PhoneBook;

public interface PhoneBook {
	public void addPerson(Worker p);
	public void removePerson(Worker p);
	public Worker searchByName(String name);
	public boolean modifyPerson(Worker p1, Worker p2);
}
