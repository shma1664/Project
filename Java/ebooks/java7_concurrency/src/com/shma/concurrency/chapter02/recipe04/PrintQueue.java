package com.shma.concurrency.chapter02.recipe04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

	private final Lock lock = new ReentrantLock(true);
	
	public void printJob() {
		lock.lock();
		try {
			long time = (long) (Math.random() * 10000) / 1000;
			System.out.println(Thread.currentThread().getName() + " has start time:" + time);
			TimeUnit.SECONDS.sleep(time);
			System.out.println(Thread.currentThread().getName() + " has finish time:" + time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
