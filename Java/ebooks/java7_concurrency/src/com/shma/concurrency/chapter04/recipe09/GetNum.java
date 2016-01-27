package com.shma.concurrency.chapter04.recipe09;

import java.util.concurrent.Callable;

public class GetNum implements Callable<Integer> {

	private int value;

	public GetNum(int value) {
		super();
		this.value = value;
	}

	@Override
	public Integer call() throws Exception {
		
		int sum = 0;
		
		for(int i=1; i<=value; ++i) {
			sum += i;
		}
		
		return sum;
	}

}
