package com.shma.concurrency.chapter01.recipe09;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
 * 线程局部变量
 */
public class SafeTask implements Runnable {

	private static final ThreadLocal<Date> THREAD_LOCAL = new ThreadLocal<Date>() {

		@Override
		protected Date initialValue() {
			return new Date();
		}
		
	};
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Starting time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(THREAD_LOCAL.get()));
		try {
			TimeUnit.SECONDS.sleep((long) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " Finished time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(THREAD_LOCAL.get()));
	}

}
