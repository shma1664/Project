package com.shma.concurrency.chapter04.recipe08;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task2 implements Runnable {

	private String name;
	
	public Task2(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%s: Executed at: %s\n", name, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
