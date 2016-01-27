package com.shma.concurrency.chapter04.recipe10;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<String> {
	
	@Override
	public String call() throws Exception {
		int time = (int) (Math.random() * 10);
		TimeUnit.SECONDS.sleep(time);
		return String.format("%s finish task, use %ds", Thread.currentThread().getName(), time);
	}

}
