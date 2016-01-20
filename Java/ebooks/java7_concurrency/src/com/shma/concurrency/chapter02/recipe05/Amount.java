package com.shma.concurrency.chapter02.recipe05;

public class Amount {

	private int oid;
	
	private double amount;

	public Amount(int oid, double amount) {
		super();
		this.oid = oid;
		this.amount = amount;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
