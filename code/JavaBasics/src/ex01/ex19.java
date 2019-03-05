package ex01;

public class ex19 {

	public static void main(String[] args) {
		String[] v1 = {"Nicola", "Marzia", "Agata", "Dharma"};
		String[] v2 = {"Nicola", "Marzia", "Agata", "Dharma"};

		if (v1.length != v2.length) {
			System.out.println("Different");
			System.exit(0);
		}
		for (int i = 0; i < v1.length; i++) {
			if (v1[i] != v2[i]) {
				System.out.println("Different");
				System.exit(0);
			}
		}
		System.out.println("Equal");
		System.exit(0);
	}
}
