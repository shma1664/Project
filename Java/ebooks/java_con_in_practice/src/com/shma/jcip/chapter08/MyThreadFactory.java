package com.shma.jcip.chapter08;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

	private final String threadName;
	
	public MyThreadFactory(String threadName) {
		this.threadName = threadName;
	}
	
	@Override
	public Thread newThread(Runnable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
