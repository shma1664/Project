package com.shma.concurrency.chapter01.recipe05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<10000; ++i) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				System.out.println("The File Clock has been interrupted");
			}
		}
	}

}
