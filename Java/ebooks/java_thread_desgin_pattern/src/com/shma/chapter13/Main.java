package com.shma.chapter13;

public class Main {

	public static void main(String[] args) {
		
		for(int i=1; i<=10; ++i) {
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int j=0; j<100; ++j) {
						Log.println(Thread.currentThread().getName() + " : ----" + j + "-----");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					Log.close();
					
				}
			}, "Log-" + i).start();
		}
	}
}
