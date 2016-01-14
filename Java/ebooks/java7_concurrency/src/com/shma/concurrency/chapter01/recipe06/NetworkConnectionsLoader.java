package com.shma.concurrency.chapter01.recipe06;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable {

	@Override
	public void run() {
		System.out.println("Beginning network connection loading:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Network connection loading has Finished:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
