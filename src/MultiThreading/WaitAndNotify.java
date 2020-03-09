package MultiThreading;

import java.util.Scanner;

class Test {
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("producer running..");
			wait();
			System.out.println("Resumed..");
		}
	}
	
	public void consume() throws InterruptedException {
		Scanner in = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("consumer running..wait for return key");
			in.nextLine();
			System.out.println("Completed..");
			notify();
			Thread.sleep(5000);
		}
	}
}

public class WaitAndNotify {

	public static void main(String[] args) {
		
		Test o = new Test();
		
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				try {
					o.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				try {
					o.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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

}
