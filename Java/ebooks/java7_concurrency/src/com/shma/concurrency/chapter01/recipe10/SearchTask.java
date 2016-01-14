package com.shma.concurrency.chapter01.recipe10;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {

	@Override
	public void run() {
		
		String threadName = Thread.currentThread().getName();
		
		System.out.printf("Thread %s: Start\n", threadName);
		
		try {
			doTask();
		} catch (InterruptedException e) {
			System.out.printf("Thread %s: Interrupted\n", threadName);
			return;
		}
		
		System.out.printf("Thread %s: End\n",threadName);
		
	}
	
	private void doTask() throws InterruptedException {
		Random random=new Random((new Date()).getTime());
		int value=(int)(random.nextDouble()*100);
		System.out.printf("Thread %s: %d\n",Thread.currentThread().getName(),value);
		TimeUnit.SECONDS.sleep(value);
	}

}
