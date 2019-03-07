package ex01;

public class StringProcessor {
	public int findShortest(String[] v) {
		int min_pos = 0;
		int min_length = 128;
		for (int i = 0; i < v.length; i++) {
			if (v[i].length() < min_length) {
				min_pos = i;
				min_length = v[i].length();
			}
		}
		return min_pos;
	}

	public int search(String[] v, String key) {
		int i;

		for (i = 0; i < v.length; i++) {
			if (v[i].equals(key))
				return i;
		}

		return -1;
	}

	public void reverse(String[] v) {
		for (int i = 0; i < v.length / 2; i++) {
			String tmp = v[i];
			v[i] = v[v.length - 1 - i];
			v[v.length - 1 - i] = tmp;
		}
	}

	public int[] findDuplicates(String[] v) {
		int[] dups = new int[v.length * 2];
		int dups_index = 0;
		for (int j = 0; j < v.length / 2; j++) {
			for (int i = 0; i < v.length; i++) {
				if (i != j && v[i].equals(v[j])) {
					dups[dups_index++] = i;
					dups[dups_index++] = j;
				}
			}
		}
		return dups;
	}

	public boolean areEqual(String[] v1, String[] v2) {
		if (v1.length != v2.length) {
			return false;
		}
		for (int i = 0; i < v1.length; i++) {
			if (v1[i] != v2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] v1 = { "Nicola", "Marzia", "Agata", "Dharma" };
		String[] v2 = { "Nicola", "Marzia", "Agata", "Dharma" };
		StringProcessor sp = new StringProcessor();

		System.out.println(sp.findShortest(v1));
		System.out.println(sp.search(v1, "Marzia"));

		sp.reverse(v1);
		for (String s : v1) {
			System.out.println(s);
		}

		for (int i : sp.findDuplicates(v1)) {
			System.out.print(i + ", ");
		}
		System.out.println();

		// False because the array has been reversed
		System.out.println(sp.areEqual(v1, v2));
	}
}
