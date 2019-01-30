package Basics;

public class App5 {
	
	public static void main(String[] args) {
		int[] v = {2, 3, 4, 5, 6, 7, 9, 9};
		double lmax = v[0];
		double lmin = v[0]; 
		double lavg = 0;
		
		for (int i : v) {
			lmax = Math.max(lmax, i);
			lmin = Math.min(lmin, i);
			lavg += i;
		}
		
		System.out.println("max = " + lmax);
		System.out.println("min = " + lmin);
		System.out.println("avg = " + lavg / v.length);
		
		
	}
	
	
	

}
