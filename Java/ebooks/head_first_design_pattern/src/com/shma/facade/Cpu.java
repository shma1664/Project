package com.shma.facade;

public class Cpu implements Behavior {

	public void startup() {
		System.out.println("cpu startup...");
	}
	
	public void shutdown() {
		System.out.println("cpu shutdown...");
	}
}
