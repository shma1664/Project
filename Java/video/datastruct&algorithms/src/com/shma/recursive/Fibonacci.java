package com.shma.recursive;

public class Fibonacci {

	public static long fibonacci(int num) {
		if(num == 1) {
			return 0L;
		}
		
		if(num == 2) {
			return 1L;
		}
		
		return fibonacci(num - 1) + fibonacci(num - 2);
	}
}
