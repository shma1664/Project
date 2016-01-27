package com.shma.concurrency.chapter04.recipe02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private Date initDate;
	
	private String name;

	public Task(Date initDate, String name) {
		super();
		this.initDate = initDate;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s: Task %s: Created on: %s\n",Thread.currentThread().getName(), name, getDate(initDate));
		System.out.printf("%s: Task %s: Started on: %s\n",Thread.currentThread().getName(), name, getDate(new Date()));
		
		int duration = (int) (Math.random() * 10);
		System.out.printf("%s: Task %s: Doing a task during %d seconds\n",Thread.currentThread().getName(),name,duration);
	
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("%s: Task %s: Finished on: %s\n",Thread.currentThread().getName(),name, getDate(new Date()));
	}
	
	private String getDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

}
