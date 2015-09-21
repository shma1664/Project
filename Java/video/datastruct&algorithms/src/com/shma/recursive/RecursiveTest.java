package com.shma.recursive;

import org.junit.Test;

public class RecursiveTest {

	/**
	 * ¥Ú”°1-100
	 */
	@Test
	public void test() {
		print(100);
	}
	
	
	public void print(int n) {
		if(n == 0) {
			return;
		}
		System.out.println(n);
		print(--n);
	}
 }
