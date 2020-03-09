package MultiThreading;

class Example {

	public void method1() {
		synchronized (String.class) {
			System.out.println("Aquired lock on String.class object");
			synchronized (Integer.class) {
				System.out.println("Aquired lock on Integer.class object");
			}
		}
	}

	public void method2() {
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println("Aquired lock on String.class object");
			}
		}
	}

}

public class Deadlock {

	public static void main(String[] args) {
		Example o = new Example();

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				o.method1();
			}

		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				o.method2();
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

}
