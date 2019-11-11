package simply.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/**
		 * Result 
		 * Final result : 0 
		 * Current result : 1 
		 * Final result : 1 
		 * Thread output :
		 * Display as result 
		 * 5 Threads output : Display as result
		 */
		CustomTask c = new CustomTask();
		Thread t = new Thread(c);
		t.start();
		System.out.println(String.format("Final result : %d", c.result()));
		Thread.sleep(3000);
		System.out.println(String.format("Final result : %d", c.result()));
		String input = "Display as result";
		ExecutorService threadService = Executors.newSingleThreadExecutor();
		Future<String> future = threadService.submit(new Callable<String>() {
			public String call() {
				return input;
			}
		});
		System.out.println(String.format("Thread output : %s", future.get()));

		ExecutorService threadService2 = Executors.newFixedThreadPool(5);
		Future<String> future2 = threadService2.submit(new Callable<String>() {
			public String call() {
				return input;
			}
		});
		System.out.println(String.format("5 Threads output : %s", future2.get()));

	}

}
