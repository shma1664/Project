package com.shma.chapter07;

import java.util.Random;

public class Customer extends Thread {

	private final Table table;
	
	private final Random random = new Random();
	
	public Customer(String threadName, Table table) {
		super(threadName);
		this.table = table;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String cake = table.take();
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
