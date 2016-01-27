package com.shma.concurrency.chapter04.recipe06;

import java.util.concurrent.Callable;

public class ExceptionCallable implements Callable<String> {

	private String name = null;
	
	public ExceptionCallable() {
		super();
	}

	public ExceptionCallable(String name) {
		super();
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		
		System.out.println("begin to ExceptionCallable.");
	    System.out.println(name.length());
	    System.out.println("end to ExceptionCallable.");

	    return name;
	}

}
