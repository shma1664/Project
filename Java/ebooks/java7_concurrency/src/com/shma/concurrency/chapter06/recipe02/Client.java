package com.shma.concurrency.chapter06.recipe02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {

	private BlockingDeque<String> deque;

	public Client(BlockingDeque<String> deque) {
		super();
		this.deque = deque;
	}

	@Override
	public void run() {
		for(int i=0; i<3; ++i) {
			for(int j=0; j<5; ++j) {
				try {
					String data = i + ":" + j;
					deque.put(data);
					System.out.printf("Client: %s at %s.\n", data, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.printf("Client: End.\n");
	}

}
