package Examples;

class Hamlet implements Runnable { 
	public void run(){ 
		while(true) {
			System.out.println(Thread.currentThread().getName());
			
			/* Explicitely releases the CPU */
			Thread.yield();
		}
	}
}

public class YieldExample {
	public static void main(String argv[]) { 
		new Thread(new Hamlet(), "To be").start();
		new Thread(new Hamlet(), "Not to be").start();
	}
}
