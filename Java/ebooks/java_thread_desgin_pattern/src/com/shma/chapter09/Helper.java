package com.shma.chapter09;

public class Helper {

	public void handle(int count, char c) {
		System.out.println("handle (" + count + ", " + c + ") begin");
		
		for(int i=0; i<count; ++i) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.print(c);
		}
		System.out.println();
		System.out.println("handle (" + count + ", " + c + ") end");
	}
}
