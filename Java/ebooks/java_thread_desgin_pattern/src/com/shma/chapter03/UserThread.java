package com.shma.chapter03;

public class UserThread extends Thread {

	private Gate gate;
	private String name;
	private String address;
	
	public UserThread(Gate gate, String name, String address) {
		super();
		this.gate = gate;
		this.name = name;
		this.address = address;
	}

	@Override
	public void run() {
		System.out.println(name + " begin...");
		while(true) {
			gate.pass(name, address);
		}
	}

}
