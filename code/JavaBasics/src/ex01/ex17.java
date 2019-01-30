package ex01;

public class ex17 {

	public static void main(String[] args) {
		String[] v = {"Nicola", "Marzia", "Agata", "Dharma"};
		
		for (int i = 0; i < v.length / 2; i++) {
			String tmp = v[i];
			v[i] = v[v.length-1-i];
			v[v.length-1-i] = tmp;
		}
		
		for (String s : v) {
			System.out.println(s);
		}
	}
}
