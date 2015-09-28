package com.shma.chapter06.balking;

import java.io.IOException;
import java.util.Random;

public class ChangerThread extends Thread {

	private final Data data;
	private final Random random = new Random();
	
	public ChangerThread(String threadName, Data data) {
		super(threadName);
		this.data = data;
	}
	
	@Override
	public void run() {
		for(int i=0; true; ++i) {
			data.changed("No." + i);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				data.save();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
