package com.shma.guava.base;

import org.junit.Test;

import com.google.common.base.Throwables;

/**
 * 异常处理
 * @author admin
 *
 */
public class ThrowablesTest {

	public void testThrowables() {
		try {
			throw new Exception();
		} catch (Throwable t) {
			String msg = Throwables.getStackTraceAsString(t);
			System.out.println("msg:" + msg);
			Throwables.propagate(t);
		}
	}
	
	@Test
	public void test() {
		testThrowables();
	}
	
	
}
