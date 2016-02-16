package com.shma.concurrency.chapter08;

import java.util.concurrent.atomic.AtomicLong;

public class Amount {
	
	public Amount() {
		
	}

	public Amount(int money) {
		counter.set(money);
	}

	private final AtomicLong counter = new AtomicLong(0);
	
	public void addMoney(int money) {
		counter.addAndGet(money);
	}
	
	public void getMoney(int money) {
		counter.addAndGet(-money);
	}
	
	public long money() {
		return counter.get();
	}
}
