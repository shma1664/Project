package com.shma.concurrency.chapter06.recipe01;

import java.util.concurrent.ConcurrentLinkedDeque;

public class AddTask implements Runnable {

	private ConcurrentLinkedDeque<String> deque = null;

	public AddTask(ConcurrentLinkedDeque<String> deque) {
		super();
		this.deque = deque;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		
		for(int i=0; i<100; ++i) {
			System.out.printf("Add>>>%s:Element:%d\n", name, i);
			deque.add(String.format("%s:Element:%d", name, i));
			
		}
	}

}
