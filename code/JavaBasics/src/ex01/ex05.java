package ex01;
import java.util.Scanner;

public class ex05 {
	public static void main(String[] args) {
		int j, n;

		System.out.print("Input the number(Table to be calculated): ");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();

		System.out.println ("\n");
		for (j = 0; j <= n; j++)
			System.out.println(n + " X " + j + " = " + n * j);
	}
}
