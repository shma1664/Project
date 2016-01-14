package com.shma.concurrency.chapter01.recipe12;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkThreadFactory implements ThreadFactory {

	private final AtomicInteger counter = new AtomicInteger();
	
	@Override
	public Thread newThread(Runnable r) {
		int c = counter.incrementAndGet();
		System.out.println("create no " + c + " Threads");
		return new WorkThread(r, counter);
	}

}
