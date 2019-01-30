package PhoneBook;

public class Worker {
	String name;
	String lastName;
	String phoneNumber;
	
	public Worker(String name, String lastName, String phoneNumber) {
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		Worker p = (Worker)obj;
		if (name.equals(p.getName()) &&
				lastName.equals(p.getLastName()) &&
				phoneNumber.equals(p.getPhoneNumber()))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + "]";
	}
}
