package com.shma.chapter08;

import java.util.Random;

public class ReadThread extends Thread {

	private final Data data;
	
	private final Random random = new Random();
	
	public ReadThread(String threadName, Data data) {
		super(threadName);
		this.data = data;
	}

	@Override
	public void run() {
		while(true) {
			try {
				char[] buffer = data.read();
				System.out.println(Thread.currentThread().getName() + " read " + String.valueOf(buffer));
				Thread.sleep(random.nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
