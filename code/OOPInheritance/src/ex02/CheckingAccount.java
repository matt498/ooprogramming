package ex02;


/**
 * A particular bank account with fees applied to each transaction
 * @author Nicola Bicocchi
 *
 */
public class CheckingAccount extends BankAccount {
	/**
	 * Number of transactions made on account
	 */
	private int transactionCount;
	
	/**
	 * Number of free transactions
	 */
	private static final int FREE_TRANSACTIONS = 3;
	
	/**
	 * Cost of a single transaction
	 */
	private static final double TRANSACTION_FEE = 2.0;

	/**
	 * Creates a checking account with an initial balance
	 * @param initialBalance The initial balance
	 */
	public CheckingAccount(double initialBalance) {
		super(initialBalance);
		transactionCount = 0;
	} 

	/**
	  * {@inheritDoc}
	  * Works like in the super class but increase transactionCount
	  */
	@Override
	public void deposit(double amount) {
		transactionCount++;
		super.deposit(amount);
	}

	/**
	  * {@inheritDoc}
	  * Works like in the super class but increase transactionCount
	  */
	@Override
	public void withdraw(double amount) {
		transactionCount++;
		super.withdraw(amount);
	}

	
	/**
	 * Withdraw from account transactions fees (only if more than free transactions). It also resets transactionCount.
	 */
	public void deductFees() {
		if (transactionCount > FREE_TRANSACTIONS) {
			double fees = TRANSACTION_FEE * (transactionCount - FREE_TRANSACTIONS);
			super.withdraw(fees); 
		}
		transactionCount = 0;
	}

	@Override
	public String toString() {
		return "CheckingAccount [transactionCount=" + transactionCount + ", balance=" + balance + "]";
	}
}