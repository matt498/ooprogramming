package ex02;

/**
 * Class for testing
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		SavingsAccount ac01 = new SavingsAccount(1000, 0.5);
		CheckingAccount ac02 = new CheckingAccount(2000);
		
		ac01.deposit(1000);
		ac01.transfer(1000, ac02);
		
		ac02.withdraw(100);
		ac02.withdraw(200);
		
		ac01.addInterest();
		ac02.deductFees();

		System.out.println(ac01);

		System.out.println(ac02);
	}
}