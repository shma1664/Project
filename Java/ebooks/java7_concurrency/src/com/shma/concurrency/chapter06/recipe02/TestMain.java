package com.shma.concurrency.chapter06.recipe02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class TestMain {

	public static void main(String[] args) {
		
		//×èÈûË«¶Ë¶ÓÁĞ
		BlockingDeque<String> deque = new LinkedBlockingDeque<String>(3);
		
		Client client = new Client(deque);
		
		new Thread(client).start();
		
		for(int i=0; i<5; ++i) {
			for(int j=0; j<3; ++j) {
				try {
					String data = deque.take();
					System.out.printf("Main: Request: %s at %s. Size: %d\n",data,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),deque.size());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		System.out.printf("Main: End of the program.\n");
	}
}
