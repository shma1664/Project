package com.shma.concurrency.chapter03.recipe02;

public class Job implements Runnable {

	private PrintQueue queue;
	
	public Job(PrintQueue queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		queue.printJob();
	}

}