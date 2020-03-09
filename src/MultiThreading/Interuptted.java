package MultiThreading;

import java.util.Random;

public class Interuptted {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			public void run() {

				Random ran = new Random();
				System.out.println("Started.....");

				for (int i = 0; i < 1E8; i++) {

					/*
					 * if (Thread.currentThread().isInterrupted()) {
					 * System.out.println("Interrupted!"); break; }
					 */

					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("Interrupted!");
						break;
					}
					Math.sin(ran.nextDouble());
				}

				System.out.println("Finished...");
			}

		});

		t1.start();

		Thread.sleep(500);

		t1.interrupt();

		t1.join();
	}

}
