package com.shma.concurrency.chapter02.recipe01;

import org.junit.Test;

public class TestMain {

	@Test
	public void test() {
		Amount amount = new Amount(1000);
		
		Thread bankThread = new Thread(new Bank(amount));
		Thread companyThread = new Thread(new Company(amount));
		
		System.out.println("Init Amount money:" + amount.getMoney());
		
		bankThread.start();
		companyThread.start();
		
		try {
			bankThread.join();
			companyThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished Amount money : " + amount.getMoney());
	}
}
