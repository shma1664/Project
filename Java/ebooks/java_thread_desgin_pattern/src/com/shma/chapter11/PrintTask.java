package com.shma.chapter11;

import java.util.Random;

public class PrintTask implements Callable<String> {

	private String msg;
	private final Random random = new Random();
	
	public PrintTask(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String call() throws Exception {
		String newMsg = "";
		for(int i=0; i<msg.length(); ++i) {
			char c = (char)(msg.charAt(i) + 1);
			System.out.println(Thread.currentThread().getName() + " making realData : " + c);
			newMsg += c;
			Thread.sleep(random.nextInt(1000));
		}
		
		return newMsg;
	}

}
