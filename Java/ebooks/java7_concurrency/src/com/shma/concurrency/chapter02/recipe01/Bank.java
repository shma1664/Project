package com.shma.concurrency.chapter02.recipe01;

public class Bank implements Runnable {

	private Amount amount;
	
	public Bank(Amount amount) {
		super();
		this.amount = amount;
	}

	@Override
	public void run() {
		for(int i=0; i<100; ++i) {
			amount.subAmount(1000);
		}
	}

}
