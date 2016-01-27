package com.shma.concurrency.chapter04.recipe09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author admin
 *
 */
public class TestMain {

	public static void main(String[] args) {
		
		Task task = new Task();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<String> result = executorService.submit(task);
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Main: Cancelling the Task\n");
		result.cancel(true);
		// Verify that the task has been cancelled
		System.out.printf("Main: Cancelled: %s\n",result.isCancelled());
		System.out.printf("Main: Done: %s\n",result.isDone());
		
		// Shutdown the executor
		executorService.shutdown();
		System.out.printf("Main: The executor has finished\n");
	}
}
