package com.shma.concurrency.chapter01.recipe04;


import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class FileSearchTest {

	@Test
	public void test() throws InterruptedException {
		Thread thread = new Thread(new FileSearch("D:/opt", "tmp_20151218103859.zip"));
		thread.start();
		
		TimeUnit.MILLISECONDS.sleep(5);
		
		thread.interrupt(); //ÖÐ¶Ï
	}

}
