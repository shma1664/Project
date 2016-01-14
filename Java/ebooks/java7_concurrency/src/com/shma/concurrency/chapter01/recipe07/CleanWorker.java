package com.shma.concurrency.chapter01.recipe07;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * 创建守护线程
 * @author shma
 *
 */
public class CleanWorker implements Runnable {

	private Deque<Event> deque;
	
	public CleanWorker(Deque<Event> deque) {
		super();
		this.deque = deque;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				clean();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void clean() throws InterruptedException {
		if(deque == null || deque.size() < 0) {
			TimeUnit.SECONDS.sleep(1);
			return;
		}
		
		Event event = deque.getLast();
		
		long difference = new Date().getTime() - event.getDate().getTime();
		if(difference > 1000) {
			System.out.println("Cleaner:" + event + ", size:" + deque.size());
		}
	}

}
