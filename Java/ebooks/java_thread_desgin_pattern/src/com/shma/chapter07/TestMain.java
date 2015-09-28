package com.shma.chapter07;

public class TestMain {

	public static void main(String[] args) {
		Table table = new Table(10);
		new Producer("producer01", table).start();
		new Producer("producer02", table).start();
		new Producer("producer03", table).start();
		new Producer("producer04", table).start();
		new Producer("producer05", table).start();
		
		
		new Customer("customer01", table).start();
		new Customer("customer02", table).start();
		new Customer("customer03", table).start();
		new Customer("customer04", table).start();
		new Customer("customer05", table).start();
	}
}
