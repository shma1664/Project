package com.shma.chapter10;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerThread extends Thread {

	private final Channel<WoTou> channel;
	
	private static final AtomicInteger counter = new AtomicInteger(0);
	
	private final Random random = new Random();
	
	public ProducerThread(String threadName, Channel<WoTou> channel) {
		super(threadName);
		this.channel = channel; 
	}
	
	@Override
	public void run() {
		while(true) {
			int i = counter.getAndIncrement();
			WoTou woTou = new WoTou(i, "name_" + i);
			try {
				channel.put(woTou);
				Thread.sleep(random.nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
