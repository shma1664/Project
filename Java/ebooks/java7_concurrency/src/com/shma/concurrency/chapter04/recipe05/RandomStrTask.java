package com.shma.concurrency.chapter04.recipe05;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class RandomStrTask implements Callable<Result> {

	private static final String CONTENT = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	
	private String name;
	
	private final int num;
	
	public RandomStrTask(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	@Override
	public Result call() throws Exception {
		
		System.out.printf("%s: Staring\n",this.name);
		
		// Waits during a random period of time
		try {
			Long duration=(long)(Math.random()*10);
			System.out.printf("%s: Waiting %d seconds for results.\n",this.name,duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		StringBuffer sb = new StringBuffer();
		
		Random random = new Random();
		
		for(int i=0; i<num; ++i) {
			int index = random.nextInt(CONTENT.length());
			sb.append(CONTENT.charAt(index));
		}
		
		Result result = new Result(name, sb.toString());
		
		System.out.printf("%s: Ends\n",this.name);
		
		return result;
	}

}
