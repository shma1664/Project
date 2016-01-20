package com.shma.concurrency.chapter02.recipe01;

public class Company implements Runnable {

	private Amount amount;

	public Company(Amount amount) {
		super();
		this.amount = amount;
	}

	@Override
	public void run() {
		for(int i=0; i<100; ++i) {
			amount.addAmount(1000);
		}
	}

}
