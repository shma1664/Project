package com.shma.concurrency.chapter02.recipe05;

public class TestMain {

	public static void main(String[] args) {
		Amount amount = new Amount(1, 1000);
		User user = new User(amount, "shma");
		Thread thread1 = new Thread(new BankGet(user), "get1");
		Thread thread2 = new Thread(new BankGet(user), "get2");
		Thread thread3 = new Thread(new BankGet(user), "get3");
		Thread thread7 = new Thread(new BankGet(user), "get4");
		Thread thread8 = new Thread(new BankGet(user), "get5");
		Thread thread9 = new Thread(new BankGet(user), "get6");
		Thread thread10 = new Thread(new BankGet(user), "get7");
		Thread thread11 = new Thread(new BankGet(user), "get8");
		
		Thread thread4 = new Thread(new BankPut(user), "put1");
		Thread thread5 = new Thread(new BankPut(user), "put2");
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread7.start();
		thread8.start();
		thread9.start();
		thread10.start();
		thread11.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();
			thread7.join();
			thread8.join();
			thread9.join();
			thread10.join();
			thread11.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finish money : " + amount.getAmount());
	}
}
