package com.shma.concurrency.chapter02.recipe01;

import java.util.concurrent.TimeUnit;

public class Amount {

	private double money;

	public Amount(double money) {
		super();
		this.money = money;
	}
	
	public void addAmount(double money) {
		try {
			TimeUnit.MILLISECONDS.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized(this) {
			this.money += money;
		}
	}
	
	public void subAmount(double money) {
		try {
			TimeUnit.MILLISECONDS.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(this) {
			this.money -= money;
		}
		
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	
}
