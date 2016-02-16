package com.shma.concurrency.chapter08;

public class Bank implements Runnable {

	private Amount amount;

	public Bank(Amount amount) {
		super();
		this.amount = amount;
	}

	@Override
	public void run() {
		for(int i=0; i<10; ++i) {
			amount.getMoney(1000);
		}
	}

}
