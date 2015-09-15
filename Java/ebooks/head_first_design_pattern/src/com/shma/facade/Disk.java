package com.shma.facade;

public class Disk implements Behavior {

	public void startup() {
		System.out.println("disk startup...");
	}
	
	public void shutdown() {
		System.out.println("disk shutdown...");
	}
}
