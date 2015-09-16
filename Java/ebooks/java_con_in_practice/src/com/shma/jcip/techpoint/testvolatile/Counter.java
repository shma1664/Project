package com.shma.jcip.techpoint.testvolatile;

import java.util.concurrent.CountDownLatch;

public class Counter {

	public volatile static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		
		final CountDownLatch latch = new CountDownLatch(1000);
		
		for(int i=0; i<1000; ++i) {
			new MyThread(latch).start();
		}
		latch.await();
		System.out.println("运行结果:Counter.count=" + count); 
	}
	
	
}

class MyThread extends Thread {

	private CountDownLatch latch;
	
	public MyThread(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		inc();
	}
	
	public void inc() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (latch) {
			Counter.count++;
		}
		latch.countDown();
	}
	
}
