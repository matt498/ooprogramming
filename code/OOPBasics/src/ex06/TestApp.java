package ex06;
import java.util.Scanner;

/**
 * Implement a simple Bingo application using two classes: Dealer and Player.
 * 
 * Class Dealer:
 * Constructor:
 *   Dealer(): create a new Dealer object
 * 
 * Methods:
 *   int exctractNumber(): return the next number between [1..90]
 *   
 * Class Player
 * Constructor:
 *   Player(String name): create a new player with a given name. Each player 
 *   holds 5 numbers (randomly assigned).
 *   
 * Methods:
 *   void checkNumber(int n): verify if Player holds number n and eventually marks it as extracted
 *   boolean bingo(): returns true if all 5 numbers have been extracted 
 *   int[] verify(): returns the 5 numbers assigned to a Player
 *   
 * Write a Java program to simulate the game.
 *   
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static final int MAX_PLAYERS = 4;

	public static void main(String[] args) {
		Dealer b = new Dealer();
		Player[] g = new Player[MAX_PLAYERS];
		int round = 0;
		
		/*
		g[0] = new Player("Luca");
		g[1] = new Player("Marco");
		g[2] = new Player("Matteo");
		g[3] = new Player("Giovanni");
		*/
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < MAX_PLAYERS; i++) {
			g[i] = new Player(scanner.next());
		}
		scanner.close();
		
		while(true) {
			round++;
			int n = b.extractNumber();
			System.out.println("Dealer exctract: " + n);
			for (int i = 0; i < MAX_PLAYERS; i++) {
				g[i].verifyNumber(n);
				if (g[i].bingo()) {
					System.out.println("Wins in " + round + " extraction: " + g[i]);
					System.exit(0);
				}
			}
		}
	}
}
