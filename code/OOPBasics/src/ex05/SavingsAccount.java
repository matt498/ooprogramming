package ex05;


public class SavingsAccount {
	public static double annualInterestRate = 0.03;
	private double balance;

	public SavingsAccount() {
		this.balance = 0;
	}
	
	public SavingsAccount(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double calculateMonthlyInterest() {
		return balance * (annualInterestRate / 12.0);
	}
	
	public static void modifyInterestRate(double ir) {
		annualInterestRate = ir;
	}

	@Override
	public String toString() {
		return "SavingsAccount [balance=" + balance + "]";
	}
	
}
