package com.shma.chapter01;

public class SingleThreadMain {

	public static void main(String[] args) {
		for(int i=0; i<10000; ++i) {
			System.out.println(Thread.currentThread().getName() + " : " + "Goods!");
		}
		
		MyThread thread = new MyThread();
		thread.start();
	}
}
