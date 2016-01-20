package com.shma.concurrency.chapter02.recipe05;

import java.util.concurrent.TimeUnit;

public class BankPut implements Runnable {

	private User user;

	public BankPut(User user) {
		super();
		this.user = user;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; ++i) {
			double money = Math.random() * 100;
			if(Math.random() * 10 / 2 == 0) {
				user.put(-money);
			} else {
				user.put(money);
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
