package com.shma.concurrency.chapter03.recipe03;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Player implements Runnable {

	private int id;
	
	private final CountDownLatch begin;
	
	private final CountDownLatch end;

	public Player(int id, CountDownLatch begin, CountDownLatch end) {
		super();
		this.id = id;
		this.begin = begin;
		this.end = end;
	}

	@Override
	public void run() {
	
		try {
			begin.await();
			int time = (int) (Math.random() * 10);
			TimeUnit.SECONDS.sleep(time);
			System.out.printf("Play %d arrived, time:%d...\n", id, time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			end.countDown();
		}
	}
	
	
}
