package com.shma.chapter03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 门类:单个线程设计模式，有且仅有一个线程可以执行，设置同步
 * @author admin
 *
 */
public class Gate {

	private final AtomicInteger counter;
	private String userName = "noBody";
	private String userAddress = "noAddress";
	
	public Gate() {
		counter = new AtomicInteger(1);
	}
	
	public void pass(String name, String address) {
		counter.getAndIncrement();
		synchronized(this) {
			userAddress = address;
			userName = name;
			check();
		}
	}
	
	@Override
	public String toString() {
		return "No." + counter.get() + " : Gate [userName=" + userName + ", userAddress=" + userAddress
				+ "]";
	}

	private void check() {
		if(userName.charAt(0) != userAddress.charAt(0)) {
			System.out.println("***** BROKEN ***** " + toString());
		}
	}
}
