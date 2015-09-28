package com.shma.chapter01.bank;

public class ClientThread extends Thread {

	private Bank bank;

	public ClientThread(Bank bank) {
		super();
		this.bank = bank;
	}

	@Override
	public void run() {
		while (true) {
           try {
        	   bank.withdraw(1000);
        	   bank.deposit(1000);
        	   
           } catch(MoneyExecption e) {
        	   System.out.println(e.getMessage());
           }
           
           try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
	}
	
	
}
