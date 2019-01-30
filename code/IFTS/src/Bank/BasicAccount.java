package Bank;

public class BasicAccount extends Account {
	public BasicAccount(int amount) {
		super(amount);
	}

	@Override
	public int withdraw(int n) {
		amount -= n;
		return amount;
	}
}
