package com.shma.chapter01.bank;

public class TestMain {

	public static void main(String[] args) {
		Bank bank = new Bank("shma", 1000);
		new ClientThread(bank).start();
		new ClientThread(bank).start();
		new ClientThread(bank).start();
		new ClientThread(bank).start();
		new ClientThread(bank).start();
	}
}
