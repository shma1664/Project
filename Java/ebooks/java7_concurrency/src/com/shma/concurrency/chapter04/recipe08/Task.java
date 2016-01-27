package com.shma.concurrency.chapter04.recipe08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Runnable {

	private String name;
	
	public Task(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s: Executed at: %s\n", name, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
