package com.shma.jcip.chapter03;

import com.shma.jcip.annotation.ThreadSafe;

@ThreadSafe
public class SafeThread {

	private final Thread thread;
	
	private SafeThread() {
		thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				doSomething();
			}
		});
	}
	
	public void doSomething() {
		
	}
	
	public static SafeThread getInstance() {
		SafeThread safeThread = new SafeThread();
		safeThread.thread.start();
		return safeThread;
	}
}
