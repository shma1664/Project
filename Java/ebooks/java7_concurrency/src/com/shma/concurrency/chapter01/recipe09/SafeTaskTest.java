package com.shma.concurrency.chapter01.recipe09;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class SafeTaskTest {

	@Test
	public void test() {
		for(int i=0; i<10; ++i) {
			new Thread(new SafeTask(), "SafeTask-" + i).start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
