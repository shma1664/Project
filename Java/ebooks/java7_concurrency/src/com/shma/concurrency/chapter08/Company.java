package com.shma.concurrency.chapter08;

public class Company implements Runnable {

	private Amount amount;

	public Company(Amount amount) {
		super();
		this.amount = amount;
	}

	@Override
	public void run() {
		for(int i=0; i<10; ++i) {
			amount.addMoney(1000);
		}
	}

}
