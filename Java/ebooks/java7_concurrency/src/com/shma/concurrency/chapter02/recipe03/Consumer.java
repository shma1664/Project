package com.shma.concurrency.chapter02.recipe03;

import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {

	private int id;
	private Basket basket;

	public Consumer(int id, Basket basket, String name) {
		super(name);
		this.id = id;
		this.basket = basket;
	}

	public void run() {
		for(int i=0; i<150; ++i) {
			basket.take();
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
