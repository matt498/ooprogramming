package PhoneBook;

public class WorkerPartTime extends Worker {
	int nHours;
	
	public WorkerPartTime(String name, 
			String lastName, 
			String phoneNumber,
			int nHours) {
		super(name, lastName, phoneNumber);
		this.nHours = nHours;
	}
	
	public int getnHours() {
		return nHours;
	}

	public void setnHours(int nHours) {
		this.nHours = nHours;
	}

	@Override
	public String toString() {
		return "WorkerPartTime [nHours=" + nHours + ", name=" + name + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	

	
	

}
