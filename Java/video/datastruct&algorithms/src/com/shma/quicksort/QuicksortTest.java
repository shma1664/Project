package com.shma.quicksort;

import org.junit.Test;

public class QuicksortTest {

	@Test
	public void test() {
		long[] arr  = new long[10];
		for(int i = 0; i < 10;i++) {
			arr[i] = (long) (Math.random() * 99);
		}
		Quicksort.display(arr);
		Quicksort.sort(arr, 0, arr.length - 1);
		Quicksort.display(arr);
	}

}
