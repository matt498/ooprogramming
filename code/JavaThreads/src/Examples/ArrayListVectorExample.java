package Examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

class Reader implements Runnable {
	List<Integer> l;

	public Reader(List<Integer> l) {
		this.l = l;
	}

	@Override
	public void run() {
		while(true) {
			System.out.println(l);
		}
	}
}

class Writer implements Runnable {
	List<Integer> l;
	boolean turn = true;
	Random rnd;

	public Writer(List<Integer> l) {
		this.l = l;
		rnd = new Random();
	}

	@Override
	public void run() {
		while(true) {
			if (turn) l.add(rnd.nextInt(100));
			if (!turn) l.remove(0);
			turn = !turn;
		}
	}
}

public class ArrayListVectorExample {
	public static void main(String[] args) throws InterruptedException {
		List<Integer> l = new Vector<Integer>();
		for (int i = 0; i < 10; i++) {
			l.add(i);
		}

		Thread t1 = new Thread(new Reader(l));
		Thread t2 = new Thread(new Writer(l));
		t1.start();
		t2.start();		
	}
}
