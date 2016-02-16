package com.shma.concurrency.chapter08;

public class TestMain {

	public static void main(String[] args) {
		Amount amount= new Amount(1000);

		Thread bank = new Thread(new Bank(amount));
		Thread company = new Thread(new Company(amount));
		System.out.printf("init money : %d\n", amount.money());
		bank.start();
		company.start();
		
		try {
			bank.join();
			company.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("end money : %d\n", amount.money());
	}
}
