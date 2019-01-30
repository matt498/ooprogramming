package PhoneBook;

public class TestApp {
	public static void main(String[] args) {
		PhoneBook pb = new PhoneBookHashMap();
		pb.addPerson(new Worker("Nicoletta", "Bicocchi", "44"));
		pb.addPerson(new Worker("Luca", "Bicocchi", "33"));
		pb.addPerson(new WorkerPartTime("Nicola", "Bianchi", "77", 16));

		Worker w = pb.searchByName("Nicola");
		if (w instanceof WorkerPartTime) {
			WorkerPartTime wp = (WorkerPartTime)w;
			System.out.println(wp.getnHours());
		}
	}
}
