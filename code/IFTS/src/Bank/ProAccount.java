package Bank;

public class ProAccount extends Account {
	public final static int FEE = 2;

	public ProAccount(int amount) {
		super(amount);
	}

	public int withdraw(int n) {
		amount -= FEE;
		return super.withdraw(n);
	}
}
