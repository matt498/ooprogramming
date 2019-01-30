package YouTubeBuffer;

import java.util.List;

class Consumer extends AbstractObservable implements Runnable {
	public int wait;
	public boolean running = true;
	protected List<Integer> l;
	protected long startPause;

	public Consumer(int wait, List<Integer> l) {
		super();

		this.wait = wait;
		this.l = l;
	}

	public void run() {
		while (running) {

			try {
				Thread.sleep(wait);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			synchronized(l) {
				if (l.size() == 0) {
					try {
						l.wait();
					} catch (InterruptedException e) {

					}
				} else {
					System.out.println("Consumer " + Thread.currentThread().getName() + " removed " + 
							l.remove(0) + " [speed=" + 1000/(double)wait + "int/sec]");
					l.notifyAll();

					// only for UI update
					notifyListeners(l.size());
				}
			}
		}
	}
}
