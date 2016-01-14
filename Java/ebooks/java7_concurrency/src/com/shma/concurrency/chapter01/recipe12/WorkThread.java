package com.shma.concurrency.chapter01.recipe12;

import java.util.concurrent.atomic.AtomicInteger;

public class WorkThread extends Thread {

	private Runnable target;   //线程执行目标
    private AtomicInteger counter;
    
	public WorkThread(Runnable target, AtomicInteger counter) {
		super();
		this.target = target;
		this.counter = counter;
	}

	@Override
	public void run() {
		try {
			target.run();
		} finally {
			int c = counter.getAndDecrement();  
            System.out.println("terminate no " + c + " Threads"); 
		}
	}
    
    
}
