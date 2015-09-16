package com.shma.jcip.chapter03;

import com.shma.jcip.annotation.ThreadSafe;

@ThreadSafe
public class CountingSheep {

	private volatile boolean asleep;
	
	public void trySleep() {
		while(asleep) {
			countSomeSheep();
		}
	}
	
	public void countSomeSheep() {
		
	}
}
