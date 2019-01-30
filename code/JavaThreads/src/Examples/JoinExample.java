package Examples;

import java.util.Random;

class Worker implements Runnable {

	@Override
	public void run() {
		Random rnd = new Random();
		System.out.println(Thread.currentThread().getName() + " starting...");
		for (int i = 0; i < 100000; i++) {
			rnd.nextInt(10000);
		}
		System.out.println(Thread.currentThread().getName() + " ending...");
	}
}

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		while(true) {
			Thread t = new Thread(new Worker(), String.format("worker_%d", i++));
			t.start();
			t.join();
		}
	}

}
