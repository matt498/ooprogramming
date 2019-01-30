package Bank;

public class Account {
	protected int amount;

	public Account(int amount) {
		this.amount = amount;
	}
	
	public int deposit(int n) {
		amount += n;
		return amount;
	}
	
	public int withdraw(int n) {
		amount -= n;
		return amount;
	}
}
