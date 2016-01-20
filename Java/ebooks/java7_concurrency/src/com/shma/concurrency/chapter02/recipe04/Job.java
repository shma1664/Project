package com.shma.concurrency.chapter02.recipe04;

public class Job implements Runnable {

	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		super();
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		printQueue.printJob();
	}
	
	
}
