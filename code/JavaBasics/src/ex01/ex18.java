package ex01;

public class ex18 {

	public static void main(String[] args) {
		String[] v = {"Nicola", "Marzia", "Agata", "Dharma", "Nicola"};

		for (int j = 0; j < v.length / 2; j++) {
			for (int i = 0; i < v.length; i++) {
				if (i != j && v[i].equals(v[j])) 
					System.out.println(j + ", " + i + " are duplicates");
			}
		}
	}
}
