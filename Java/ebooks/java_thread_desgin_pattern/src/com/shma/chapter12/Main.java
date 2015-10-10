package com.shma.chapter12;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		CountUpThread thread = new CountUpThread("countUpThread");
		thread.start();
		
		Thread.sleep(5000);
		
		System.out.println(Thread.currentThread().getName() + " : shutdown thread request");
		
		thread.showDownRequest();
		
		System.out.println(Thread.currentThread().getName() + " : join");
		
		//等待线程结束
		thread.join();
		
		System.out.println(Thread.currentThread().getName() + " : end");
	}
}
