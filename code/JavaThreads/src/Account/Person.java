package Account;

import java.util.Random;

public class Person implements Runnable { 
	private Account account;
	private Random rnd;

	public Person(Account account) {
		rnd = new Random();
		this.account = account;
	}

	public void run() {
		while (true) {
			synchronized(account) {
				int amount = rnd.nextInt(50);
				if (account.getBalance() < amount) break;
				System.out.println(Thread.currentThread().getName() + " is going to withdraw [balance = " + 
						account.getBalance() + ", " + amount + "]");

				account.withdraw(amount);

				System.out.println(Thread.currentThread().getName() + " completes the withdrawal [balance = " + 
						account.getBalance() + "]");

				if (account.getBalance() < 0) {
					System.out.println(Thread.currentThread().getName() + " Doh!!! [balance = " + 
							account.getBalance() + "]");
					break;
				}
			}

			// sleeps a bit!
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
		}
	}
}
