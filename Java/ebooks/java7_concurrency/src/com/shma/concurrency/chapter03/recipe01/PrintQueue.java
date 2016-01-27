package com.shma.concurrency.chapter03.recipe01;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrintQueue {

	private final Semaphore semaphore = new Semaphore(1);
	
	public void printJob() {
		try {
			semaphore.acquire();
			
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Print a job duration \n", Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(duration);
			System.out.printf("%s: PrintQueue: Print a job end \n", Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	
	
	
}
