package com.shma.jcip.chapter05;

import java.util.concurrent.CountDownLatch;

public class TestHarness {

	public long timeTasks(int threadNum, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(threadNum);
		
		for(int i=0; i<threadNum; ++i) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						startGate.await();
						
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		long startTime = System.currentTimeMillis();
		startGate.countDown();
		endGate.await();
		long endTime = System.currentTimeMillis();
		
		return endTime - startTime;
	}
}
