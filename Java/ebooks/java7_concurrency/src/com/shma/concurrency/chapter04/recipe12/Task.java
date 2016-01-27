package com.shma.concurrency.chapter04.recipe12;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private String name;
	
	public Task(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("Task %s: Starting\n",name);
		try {
			Long duration=(long)(Math.random()*10);
			System.out.printf("Task %s: ReportGenerator: Generating a report during %d seconds\n",name,duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		System.out.printf("Task %s: Ending\n",name);
	}

	@Override
	public String toString() {
		return "Task [name=" + name + "]";
	}

}