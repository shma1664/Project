package com.shma.chapter06.timeout;

public class Host {

	private final long timeout;
	
	private volatile boolean isReady = false;
	
	public Host(long timeout) {
		this.timeout = timeout;
	}
	
	public void setSate(boolean on) {
		this.isReady = on;
		synchronized(this) {
			this.notifyAll();
		}
	}
	
	public void execute() throws TimeoutException, InterruptedException {
		long start = System.currentTimeMillis();
		
		while(!isReady) {
			long now = System.currentTimeMillis();
			long rest = timeout - (now - start);
			if(rest <= 0) {
				throw new TimeoutException("now-start:" + (now - start) + ", timeout:" + timeout);
			}
			synchronized(this) {
				wait(rest);
			}
		}
		
		System.out.println(Thread.currentThread().getName() + " execute ");
	}
}
