package com.shma.concurrency.chapter06.recipe01;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PoolTask implements Runnable {

	private ConcurrentLinkedDeque<String> deque = null;

	public PoolTask(ConcurrentLinkedDeque<String> deque) {
		super();
		this.deque = deque;
	}

	@Override
	public void run() {
		for(int i=0; i<5000; ++i) {
			System.out.println(deque.pollFirst());
			System.out.println(deque.pollLast());
		}
	}

}
