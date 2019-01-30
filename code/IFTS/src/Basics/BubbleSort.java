package Basics;

public class BubbleSort {
	public static void main(String[] args) {
		int[] v = {1,2,3,4,5,6,7,8,9,10,9};

		boolean somethingHasChanged = true;
		while(somethingHasChanged) {
			somethingHasChanged = false;
			for (int i = 0; i<v.length-1; i++) {
				System.out.println(v[i] + " " + v[i+1]);
				if (v[i] > v[i+1]) {
					somethingHasChanged = true;
					int tmp = v[i];
					v[i] = v[i+1];
					v[i+1] = tmp;
				}
			}
		}

		for (int i : v) {
			System.out.println(i);
		}

	}



}
