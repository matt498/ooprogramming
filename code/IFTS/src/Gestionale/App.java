package Gestionale;

public class App {
	public static void main(String[] args) {
		Company c = new Company();
		
		WorkRoom wr1 = new WorkRoom("WR01");
		WorkRoom wr2 = new WorkRoom("WR02");
		WorkRoom wr3 = new WorkRoom("WR03");
		
		wr1.addPerson(new Person("Nicola", "Bicocchi", 38));
		wr1.addPerson(new Person("Luisa", "Rossi", 58));
		
		wr2.addPerson(new Person("Luca", "Bianchi", 38));
		wr2.addPerson(new Person("Gianni", "Pascoli", 58));

		wr3.addPerson(new Person("Ludovico", "Verdi", 38));
		wr3.addPerson(new Person("Gianni", "Pinotto", 58));
		
		c.addWorkRoom(wr1);
		c.addWorkRoom(wr2);
		c.addWorkRoom(wr3);
		
		WorkRoom r = c.searchWorkRoom("WR01");
		r.addPerson(new Person("Ippolito", "Nievo", 58));
		
	}

}
