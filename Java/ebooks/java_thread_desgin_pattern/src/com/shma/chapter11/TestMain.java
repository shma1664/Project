package com.shma.chapter11;

public class TestMain {

	public static void main(String[] args) {
		
		System.err.println("Main begin...");
		
		Future<String> future = new FutureTask<String>(new PrintTask("woshizhonguorenwewewe"));
		System.err.println("future begin...");
		future.execute();
		System.err.println("future end...");
		
		System.err.println("Main other begin...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("Main other end...");
		
		String msg = future.get();
		
		System.out.println(msg);
		
		System.err.println("Main end...");
	}
}
