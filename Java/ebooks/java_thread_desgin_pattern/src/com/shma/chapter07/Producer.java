package com.shma.chapter07;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Producer extends Thread {

	private final Table table;
	
	private final Random random = new Random();
	
	private final  AtomicLong number = new AtomicLong(1);

	public Producer(String threadName, Table table) {
		super(threadName);
		this.table = table;
	}

	@Override
	public void run() {
		while (true) {
			String cake = "[Cake No." + number.getAndIncrement() + ", by " + Thread.currentThread().getName() +"]";
			try {
				table.put(cake);
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
