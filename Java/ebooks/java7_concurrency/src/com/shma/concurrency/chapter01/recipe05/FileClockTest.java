package com.shma.concurrency.chapter01.recipe05;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class FileClockTest {

	@Test
	public void test() throws InterruptedException {
		
		Thread thread =new Thread(new FileClock());
		thread.start();
		
		TimeUnit.SECONDS.sleep(8);
		
		thread.interrupt(); //中断 ,中断后线程退出
		
		
	}

}
