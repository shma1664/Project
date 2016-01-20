package com.shma.concurrency.chapter02.recipe04;

import java.util.concurrent.TimeUnit;

public class TestMain {

	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		
		for(int i=0; i<10; ++i) {
			new Thread(new Job(printQueue), "Thread-" + i).start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
