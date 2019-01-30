package Basics;

public class ArrayProcessor {
	public static double max(double[] v) {
		double lmax = v[0];
		for (double i : v) {
			lmax = Math.max(lmax, i);
		}
		return lmax;
	}

	public static double min(double[] v) {
		double lmin = v[0];
		for (double i : v) {
			lmin = Math.min(lmin, i);
		}
		return lmin;
	}

	public static double sum(double[] v) {
		double sum = 0;
		for (double i : v) {
			sum += i;
		}
		return sum;
	}

	public static double avg(double[] v) {
		double sum = 0;
		for (double i : v) {
			sum += i;
		}
		return sum / v.length;
	}

	public static void sort(double[] v) {
		boolean somethingHasChanged = true;
		while(somethingHasChanged) {
			somethingHasChanged = false;
			for (int i = 0; i<v.length-1; i++) {
				System.out.println(v[i] + " " + v[i+1]);
				if (v[i] > v[i+1]) {
					somethingHasChanged = true;
					double tmp = v[i];
					v[i] = v[i+1];
					v[i+1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		double[] v = {1,2,33,4,45,4};
		System.out.println(ArrayProcessor.max(v));
		System.out.println(ArrayProcessor.min(v));
		System.out.println(ArrayProcessor.avg(v));
		System.out.println(ArrayProcessor.sum(v));
	}
}