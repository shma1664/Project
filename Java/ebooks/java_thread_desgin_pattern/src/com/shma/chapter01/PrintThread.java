package com.shma.chapter01;

public class PrintThread extends Thread {

	private String message;
	
	public PrintThread(String message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; ++i) {
			System.out.println(Thread.currentThread().getName() + ":" + message);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new PrintThread("Good!").start();
		new PrintThread("Nice!").start();
	}

}
