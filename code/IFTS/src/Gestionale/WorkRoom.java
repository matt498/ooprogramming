package Gestionale;

import java.util.ArrayList;

public class WorkRoom {
	protected String ID;
	protected String description;
	protected ArrayList<Person> lp;
	
	public WorkRoom(String ID) {
		this.ID = ID;
		lp = new ArrayList<Person>();
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addPerson(Person p) {
		lp.add(p);
	}
	
	public void removePerson(Person p) {
		lp.remove(p);
	}
	
	public Person searchPerson(String lastname) {
		for (Person p : lp) {
			if (p.getLastname().equals(lastname))
				return p;
		}
		return null;
	}

}
