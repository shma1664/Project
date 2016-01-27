package com.shma.concurrency.chapter04.recipe10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for(int i=0; i<10; ++i) {
			Task task = new Task();
			MyFutureTask futureTask = new MyFutureTask(task);
			executorService.submit(futureTask);
		}
		
		executorService.shutdown();
	}
}
