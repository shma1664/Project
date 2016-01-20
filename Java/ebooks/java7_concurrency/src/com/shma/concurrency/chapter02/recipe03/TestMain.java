package com.shma.concurrency.chapter02.recipe03;

public class TestMain {

	public static void main(String[] args) {
		Basket basket = new Basket(10);

		Producer producer1 = new Producer(1, basket, "producer1");
		Producer producer2 = new Producer(2, basket, "producer2");
		Producer producer3 = new Producer(2, basket, "producer3");
		
		Consumer consumer1 = new Consumer(1, basket, "consumer1");
		Consumer consumer2 = new Consumer(2, basket, "consumer2");
		
		producer1.start();
		producer2.start();
		producer3.start();
		
		consumer1.start();
		consumer2.start();
		
		
		try {
			producer1.join();
			producer2.join();
			producer3.join();
			consumer1.join();
			consumer2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		System.out.println("Àº¿ðÊ£Óà¸öÊý:" + basket.getDataList().size());
		
	}
}
