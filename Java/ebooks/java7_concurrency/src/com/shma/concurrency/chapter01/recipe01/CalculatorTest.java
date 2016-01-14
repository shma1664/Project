package com.shma.concurrency.chapter01.recipe01;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void test() {
		for(int i=1; i<=10; ++i) {
			Calculator calculator = new Calculator(i);
			new Thread(calculator, "Thread-" + i).start();
		}
	}

}
