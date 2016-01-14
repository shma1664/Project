package com.shma.concurrency.chapter01.recipe12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class WorkThreadFactoryTest {

	@Test
	public void test() throws InterruptedException {
	
		ExecutorService exec = Executors.newCachedThreadPool(new WorkThreadFactory());
		
		exec.execute(new WorkRunnable());
		exec.execute(new WorkRunnable());
		exec.execute(new WorkRunnable());
		exec.execute(new WorkRunnable());
		exec.execute(new WorkRunnable());
		exec.execute(new WorkRunnable());
		exec.execute(new WorkRunnable());
		exec.execute(new WorkRunnable());
		exec.execute(new WorkRunnable());
		
		exec.shutdown();
		exec.awaitTermination(2*60, TimeUnit.SECONDS);  
		
	}

}
