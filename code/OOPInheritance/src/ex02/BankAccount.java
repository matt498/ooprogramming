package ex02;

/**
 * Class representing a bank account
 * @author Nicola
 *
 */
public abstract class BankAccount {
	/**
	 * Balance of the bank account
	 */
	double balance;

	
	/**
	 * Creates an empty bank account
	 */
	public BankAccount() {
		balance = 0;
	}

	/**
	 * Creates a bank account with an initial balance
	 * @param initialBalance The initial balance
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}

	/**
	 * Increase balance by amount
	 * @param amount
	 */
	public void deposit(double amount) {
		balance = balance + amount;
	}

	/**
	 * Decrease balance by amount
	 * @param amount
	 */
	public void withdraw(double amount) {
		balance = balance - amount;
	}

	/**
	 * Return current balance of the account
	 * @return Current balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Withdraw amount from local account and deposit the same amount to other account
	 * @param amount
	 * @param other
	 */
	public void transfer(double amount, BankAccount other) {
		withdraw(amount);
		other.deposit(amount);
	}
} 