package com.shma.concurrency.chapter01.recipe07;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WorkerTask implements Runnable {

	private Deque<Event> deque;
	
	public WorkerTask(Deque<Event> deque) {
		super();
		this.deque = deque;
	}

	@Override
	public void run() {
		for(int i=0;i<100; ++i) {
			Event event = new Event(Thread.currentThread().getName() + "_" + i, new Date());
			deque.addFirst(event);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
