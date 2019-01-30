package ex01;

public class ex15 {

	public static void main(String[] args) {
		String[] v = {"Nicola", "Marzia", "Agata", "Dharma"};
		
		int min_pos = 0;
		int min_length = 128;
		for (int i = 0; i < v.length; i++) {
			if (v[i].length() < min_length) {
				min_pos = i;
				min_length = v[i].length();
			}
		}
		System.out.println(v[min_pos] + " --> " + min_length);
	}
}
