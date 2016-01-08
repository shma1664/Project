package com.shma.bigtalk.strategy;

import org.junit.Test;

public class TestMain {

	@Test
	public void test() {
		CashContext context = new CashContext("打8折");
		System.out.println(context.getResult(600));
		
		context = new CashContext("正常收费");
		System.out.println(context.getResult(600));
		
		context = new CashContext("满300减100");
		System.out.println(context.getResult(600));
	}
}
