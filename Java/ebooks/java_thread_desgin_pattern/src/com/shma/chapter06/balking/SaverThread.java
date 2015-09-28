package com.shma.chapter06.balking;

import java.io.IOException;
import java.util.Random;

/**
 * 自动保存线程
 * @author admin
 *
 */
public class SaverThread extends Thread {

	private final Random random = new Random();
	
	private final Data data;
	
	public SaverThread(String threadName, Data data) {
		super(threadName);
		this.data = data;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				data.save();
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
