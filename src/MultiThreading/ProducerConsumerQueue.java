package MultiThreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerQueue {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 1000; i++) {
					try {
						producer();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 1000; i++) {
					try {
						consumer();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void producer() throws InterruptedException {
		Random random = new Random();

		while (true) {
			queue.put(random.nextInt(100));
		}
	}

	public static void consumer() throws InterruptedException {
		Random random = new Random();

		while (true) {
			Thread.sleep(100);
			if (random.nextInt(10) == 0) {
				Integer val = queue.take();

				System.out.println("taken value: " + val + " Queue size: " + queue.size());
			}
		}
	}
}
