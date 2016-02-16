package com.shma.concurrency.chapter07;

import java.util.concurrent.ThreadLocalRandom;

public class MyThreadLocalRandom implements Runnable {

	public MyThreadLocalRandom() {
		ThreadLocalRandom.current();
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		for(int i =0; i<10; ++i) {
			System.out.printf("%s:%d\n", threadName, ThreadLocalRandom.current().nextInt(10));
		}
	}

}
