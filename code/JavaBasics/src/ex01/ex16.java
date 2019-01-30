package ex01;

public class ex16 {

	public static void main(String[] args) {
		String[] v = {"Nicola", "Marzia", "Agata", "Dharma"};
		String searchName = "Marzia";
		int i;
		
		for (i = 0; i < v.length; i++) {
			if (v[i].equals(searchName)) break;
		}
		
		System.out.println(searchName + " --> " + i);
	}
}
