package ex05;


/**
 * Create class SavingsAccount. Use a static variable annualInterestRate to store 
 * the annual interest rate for all account holders. Provide a static method 
 * modifyInterestRate that sets the annualInterestRate to a new value.
 * 
 * The class contains a private instance variable "balance" indicating the 
 * amount of the deposit. 
 * 
 * Provide a method calculateMonthlyInterest to calculate 
 * the monthly interest by multiplying the balance by annualInterestRate 
 * divided by 12. 
 * 
 * Write a program to test the class SavingsAccount. Instantiate two savingsAccount 
 * objects, saver1 and saver2, with balances of $2000.00 and $3000.00, respectively. 
 * Set annualInterestRate to 4%, then calculate the monthly interest and print the 
 * new balances for both savers. Then set the annualInterestRate to 5%, calculate 
 * the next month’s interest and print the new balances for both savers.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		
		SavingsAccount.modifyInterestRate(0.04);
		saver1.setBalance(saver1.getBalance() + saver1.calculateMonthlyInterest());
		saver2.setBalance(saver2.getBalance() + saver2.calculateMonthlyInterest());
		System.out.println(saver1);
		System.out.println(saver2);
		
		SavingsAccount.modifyInterestRate(0.05);
		saver1.setBalance(saver1.getBalance() + saver1.calculateMonthlyInterest());
		saver2.setBalance(saver2.getBalance() + saver2.calculateMonthlyInterest());
		System.out.println(saver1);
		System.out.println(saver2);
		

	}

}
