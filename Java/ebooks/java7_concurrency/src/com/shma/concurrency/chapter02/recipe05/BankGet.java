package com.shma.concurrency.chapter02.recipe05;

import java.util.concurrent.TimeUnit;


public class BankGet implements Runnable {

	private User user;

	public BankGet(User user) {
		super();
		this.user = user;
	}

	@Override
	public void run() {
		for(int i=0; i<10; ++i) {
			user.get();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
