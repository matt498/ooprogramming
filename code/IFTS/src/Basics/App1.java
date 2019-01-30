package Basics;
import java.util.Random;

public class App1 {
	public static void main(String[] args) {
		Random rnd = new Random();
		int[] v = new int[1000];
		
		for(int i = 0; i < v.length; i++) {
			v[i] = rnd.nextInt(1000);
		}
		
		for(int i = 0; i < v.length; i++) {
			System.out.println(v[i]);
		}
		
		double sum = 0;
		for(int i = 0; i < v.length; i++) {
			sum += v[i];
		}
		System.out.println(sum/v.length);
	}
}
