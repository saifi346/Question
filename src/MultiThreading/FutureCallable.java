package MultiThreading;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallable {

	public static void main(String[] args) {

		ExecutorService executors = Executors.newCachedThreadPool();
		
		Future<Integer> future = executors.submit(new Callable<Integer>() {

			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				if(duration>2000)
					throw new IOException("Sleeping for too long");
				System.out.println("Starting......");
				
				Thread.sleep(duration);
				
				System.out.println("Finished");
				
				return duration;
			}
			
		});
		
		executors.shutdown();
		
		//future.cancel(true);
		//future.isCancelled();
		
		try {
			System.out.println("Rsult is :  "+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("task completed :  "+future.isDone());
	}

}
