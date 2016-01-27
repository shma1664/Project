package com.shma.concurrency.chapter03.recipe02;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

	private boolean[] freePrints = new boolean[3];
	private Semaphore semaphore = new Semaphore(3);
	
	private Lock lock = new ReentrantLock();
	
	public PrintQueue() {
		super();
		for(int i=0; i<freePrints.length; ++i) {
			freePrints[i] = true;
		}
	}
	
	public void printJob() {
		try {
			semaphore.acquire();
			int printId = getPrintId();
			int time = (int) (Math.random() * 10);
			System.out.printf("%s 使用%d打印机开始打印...\n", Thread.currentThread().getName(),printId);
			TimeUnit.SECONDS.sleep(time);
			System.out.printf("%s 使用%d打印机完成打印，处理花费了%d时间,信号量个数%d\n", Thread.currentThread().getName(), printId, time, semaphore.availablePermits());
			freePrints[printId] = true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	
	private int getPrintId() {
		
		int printId = -1;
		
		while(printId == -1) {
			lock.lock();
			
			try {
				for(int i=0; i<freePrints.length; ++i) {
					if(freePrints[i]) {
						freePrints[i] = false;
						printId = i;
						break;
					}
				}
			} finally {
				lock.unlock();
			}
		}
		
		return printId;
	}
	
	
}
