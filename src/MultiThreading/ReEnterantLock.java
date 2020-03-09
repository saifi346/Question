package MultiThreading;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Test2 extends Thread {
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	private void increment() {
		for (int i = 0; i < 1000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Wiating");
		cond.await();
		
		System.out.println("Woken up");
		try {
			increment();
		}
		finally {
			lock.unlock();
		}
		
	}
	
	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("press return key....");
		new Scanner(System.in).nextLine();
		System.out.println("Gotcha...");
		
		cond.signal();
		
		try {
			increment();
		}
		finally {
			lock.unlock();
		}
		
	}
	
	
	public void doWork() {
		Thread t1 = new Thread(new Runnable() {

			public void run() {

				try {
					firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
					try {
						secondThread();
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
		System.out.println("Count : " + count);
	}
}

public class ReEnterantLock {

	public static void main(String[] args) {
		Test2 app = new Test2();
		app.doWork();
	}

}
