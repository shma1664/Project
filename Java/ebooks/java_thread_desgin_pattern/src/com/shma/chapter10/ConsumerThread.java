package com.shma.chapter10;

import java.util.Random;

public class ConsumerThread extends Thread {
	
	private final Channel<WoTou> channel;
	
	private final Random random = new Random();
	
	public ConsumerThread(String threadName, Channel<WoTou> channel) {
		super(threadName);
		this.channel = channel;
	}

	@Override
	public void run() {
		while(true) {
			try {
				WoTou woTou = channel.take();
				Thread.sleep(random.nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
