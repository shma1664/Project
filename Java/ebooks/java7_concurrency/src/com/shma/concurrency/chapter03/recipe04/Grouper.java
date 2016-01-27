package com.shma.concurrency.chapter03.recipe04;

public class Grouper implements Runnable {

	private Results results;
	
	public Grouper(Results results) {
		super();
		this.results = results;
	}

	@Override
	public void run() {
		int finalResult = 0;
		System.out.printf("Grouper: Processing results...\n");
		for(int counter : results.getData()) {
			finalResult += counter;
		}
		System.out.printf("Grouper: Total result: %d.\n",finalResult);
		
	}

}
