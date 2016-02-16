package com.shma.concurrency.chapter07;

public class TestMain {

	public static void main(String[] args) {
		for(int i=0; i<3; ++i) {
			new Thread(new MyThreadLocalRandom(), "thread-" + i).start();
		}
	}
}
