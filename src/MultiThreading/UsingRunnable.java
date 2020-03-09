package MultiThreading;

class Runner2 implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class UsingRunnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner2());
		Thread t2 = new Thread(new Runner2());

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		Thread t3 = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("HEY: " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});
		
		t3.start();

	}

}
