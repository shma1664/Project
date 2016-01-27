package com.shma.concurrency.chapter03.recipe02;

public class TestMain {

	public static void main(String[] args) {
		
		PrintQueue queue = new PrintQueue();
		
		int num = 10;
		
		Thread[] threads = new Thread[num];
		
		for(int i=0; i<num; ++i) {
			threads[i] = new Thread(new Job(queue));
			threads[i].start();
		} 
		
		for(int i=0; i<num; ++i) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		System.out.println("end.....");
		
	}
}
