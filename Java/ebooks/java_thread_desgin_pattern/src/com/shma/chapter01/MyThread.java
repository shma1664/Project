package com.shma.chapter01;

public class MyThread extends Thread {

	@Override
	public void run() {
		for(int i=0; i<10000; ++i) {
			System.out.println(Thread.currentThread().getName() + " : " + "Nices!");
		}
	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
	}

}
