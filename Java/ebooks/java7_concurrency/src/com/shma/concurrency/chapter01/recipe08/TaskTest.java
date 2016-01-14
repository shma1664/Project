package com.shma.concurrency.chapter01.recipe08;

import org.junit.Test;

public class TaskTest {

	@Test
	public void test() {
		Task task = new Task();
		Thread thread = new Thread(task);
		
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Thread has finished\n");
	}

}
