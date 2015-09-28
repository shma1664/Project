package com.shma.chapter05;

import java.util.Random;

public class ServerThread extends Thread {

	private final Random random = new Random();
	
	private RequestQueue queue;
	
	public ServerThread(RequestQueue queue, String threadName) {
		super(threadName);
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Request request = queue.get();
				System.out.println(Thread.currentThread().getName() + " handle " + request);
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}

}
