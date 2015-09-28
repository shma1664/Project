package com.shma.chapter05;

import java.util.Random;

public class ClientThread extends Thread {

	private final Random random = new Random();
	
	private final RequestQueue queue;
	
	public ClientThread(RequestQueue queue, String threadName) {
		super(threadName);
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10000; ++i) {
			Request request = new Request(Thread.currentThread().getName() + "-No." + i);
			System.out.println(Thread.currentThread().getName() + " request " + request);
			queue.put(request);
			
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
