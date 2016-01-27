package com.shma.concurrency.chapter04.recipe12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestMain {

	public static void main(String[] args) {
		
		ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		executorService.setRejectedExecutionHandler(new RejectedTaskController());
		for(int i=0; i<3; ++i) {
			Task task = new Task("task-" + i);
			executorService.submit(task);
		}
		// Shutdown the executor
		System.out.printf("Main: Shuting down the Executor.\n");
		executorService.shutdown();
		
		System.out.printf("Main: Sending another Task.\n");
		Task task = new Task("task-4");
		executorService.submit(task);
		
		System.out.printf("Main: End.\n");
		
		
	}
}
