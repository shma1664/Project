package com.shma.bigtalk.strategy;

import org.junit.Test;

public class TestMain {

	@Test
	public void test() {
		CashContext context = new CashContext("��8��");
		System.out.println(context.getResult(600));
		
		context = new CashContext("�����շ�");
		System.out.println(context.getResult(600));
		
		context = new CashContext("��300��100");
		System.out.println(context.getResult(600));
	}
}
