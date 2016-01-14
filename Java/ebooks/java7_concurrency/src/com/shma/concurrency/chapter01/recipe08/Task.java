package com.shma.concurrency.chapter01.recipe08;

public class Task implements Runnable {

	@Override
	public void run() {
		Integer value = Integer.parseInt("shma");
	}

}
