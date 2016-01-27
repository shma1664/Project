package com.shma.concurrency.chapter04.recipe09;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<String> {

	@Override
	public String call() throws Exception {
		
		while(true) {
			System.out.printf("%s task test....\n", Thread.currentThread().getName());
			TimeUnit.MILLISECONDS.sleep(500);
		}
	}

}
