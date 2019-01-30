package Basics;

public class Fibonacci {
	public static void main(String[] args) {
		int[] lastTwo = {0, 1};

		for (int i = 0; i < 10; i++) {
			int f = lastTwo[0] + lastTwo[1];
			
			lastTwo[0] = lastTwo[1];
			lastTwo[1] = f;
			
			System.out.printf("[%d, %d] --> %d\n", 
					lastTwo[0],
					lastTwo[1],
					f);
		}
	}



}
