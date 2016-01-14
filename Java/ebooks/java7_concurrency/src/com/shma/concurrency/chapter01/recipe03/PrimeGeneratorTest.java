package com.shma.concurrency.chapter01.recipe03;

import org.junit.Test;

public class PrimeGeneratorTest {

	@Test
	public void test() throws InterruptedException {
		PrimeGenerator primeGenerator = new PrimeGenerator();
		primeGenerator.start();
		
		Thread.sleep(5000);
		
		primeGenerator.interrupt(); //ÖÐ¶ÏÏß³Ì
	}

}
