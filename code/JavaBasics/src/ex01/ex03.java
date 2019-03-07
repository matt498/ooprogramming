package ex01;

import java.util.Scanner;

public class ex03 {
	public static void main(String[] args) {
		System.out.print("Input a number: ");

		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		in.close();

		int digits = new Integer(input).toString().length();
		for (int d = digits - 1; d >= 0; d--) {
			int n = input / ((int) Math.pow(10, d)) % 10;
			System.out.print(n + " ");
		}
	}
}