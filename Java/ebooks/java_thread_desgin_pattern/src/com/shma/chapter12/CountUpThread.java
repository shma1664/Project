package com.shma.chapter12;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 优雅的关闭线程
 * @author admin
 *
 */
public class CountUpThread extends Thread {

	private final AtomicInteger counter = new AtomicInteger(0);
	
	private volatile boolean shutDownRequest = false;
	
	public CountUpThread(String threadName) {
		super(threadName);
	}

	public void showDownRequest() {
		shutDownRequest = true;
		this.interrupt(); //中断线程,sleep wait
	}
	
	public boolean ishutDownRequest() {
		return shutDownRequest;
	}
	
	@Override
	public void run() {
		
		try {
			while(!shutDownRequest) {
				doWork();
			}
			
		} catch (InterruptedException e) {
		} finally {
			doShutDown();
		}
		
		
	}
	
	private void doShutDown() {
		System.out.println(Thread.currentThread().getName() + " shutdown, counter:" + counter.get());
	}

	private void doWork() throws InterruptedException {
		System.out.println("doWork: counter : " + counter.incrementAndGet());
		Thread.sleep(1000);
	}

}
