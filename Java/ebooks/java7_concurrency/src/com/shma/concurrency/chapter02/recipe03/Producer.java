package com.shma.concurrency.chapter02.recipe03;

import java.util.concurrent.TimeUnit;

public class Producer extends Thread {

	private int id;
	private Basket basket;

	public Producer(int id, Basket basket, String name) {
		super(name);
		this.id = id;
		this.basket = basket;
	}

	public void run() {
		for(int i=0; i<100; ++i) {
			WoTou woTou = new WoTou(i, String.format("wotou>>>id:%d, no:" + i, id));
			basket.put(woTou);
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
