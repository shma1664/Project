package com.shma.concurrency.chapter04.recipe03;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Long> {

	private int number;
	
	public FactorialCalculator(int number) {
		super();
		this.number = number;
	}

	@Override
	public Long call() throws Exception {
		
		long value = 1L;
		
		if(number == 0 || number == 1) {
			value = 1L;
		}
		
		for(int i=2; i<=number; ++i) {
			value *= i;
			TimeUnit.MILLISECONDS.sleep(100);
		}
		
		System.out.printf("%s: %d\n",Thread.currentThread().getName(), value);
		
		return value;
	}

}
