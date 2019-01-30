package ex02;

/**
 * A particular bank account with interests on deposits
 * @author Nicola Bicocchi
 *
 */
public class SavingsAccount extends BankAccount {
	/**
	 * The interest rate applied
	 */
	private double interestRate;

	/**
	 * Creates a saving account with specified initial balance and interst rate
	 * @param initialBalance
	 * @param interestRate
	 */
	public SavingsAccount(double initialBalance, double interestRate) {
		super(initialBalance);
		this.interestRate = interestRate;
	}

	/**
	 * Deposits matured interest
	 */
	public void addInterest() {
		double interest = getBalance() * interestRate / 100;
		deposit(interest);
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + ", balance=" + balance + "]";
	}
}