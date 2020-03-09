package MultiThreading;

import java.util.Scanner;

class Process extends Thread {
	private volatile boolean running = true;
	
	public void run() {
		while(running) {
			System.out.println("Hello: ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutDown() {
		running=false;
	}
}

public class VolatileUse {

	public static void main(String[] args) {
		Process p1 = new Process();
		p1.start();
		 System.out.println("press enter to stop....");
		 Scanner in = new Scanner(System.in);
		 in.nextLine();
		 p1.shutDown(); 
		 
	}

}
