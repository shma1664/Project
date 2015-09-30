package com.shma.chapter08;

import java.util.Random;

public class WriterThread extends Thread {

	private final Data data;
	
	private String filler;
	
	private int index;
	
	private final Random random = new Random();
	
	public WriterThread(String threadName, Data data, String filler) {
		super(threadName);
		this.data = data;
		this.filler = filler;
	}
	
	@Override
	public void run() {
		while(true) {
			
			try {
				data.write(getChar());
				Thread.sleep(random.nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private char getChar() {
		index = (index + 1) % filler.length();
		return filler.charAt(index);
	}

}
