package com.shma.concurrency.chapter06.recipe03;

import java.util.concurrent.PriorityBlockingQueue;

public class Task implements Runnable {

	private int id;
	
	private PriorityBlockingQueue<Event> queue;

	public Task(int id, PriorityBlockingQueue<Event> queue) {
		super();
		this.id = id;
		this.queue = queue;
	}

	@Override
	public void run() {
		for(int i=0; i<1000; ++i) {
			Event event = new Event(String.format("task-%d-%d", id, i), i);
			queue.add(event);
		}
	}
}
