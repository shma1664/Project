package com.shma.sort;
import org.junit.Test;

public class ShellSortTest {

	@Test
	public void test() {
		long[] arr = {27L, 13L, 81L, 59L, 37L, 1L, 99L, 3L, 2L, 22L};
		print(arr);
		ShellSort.sort(arr);
		
		print(arr);
	}
	
	private void print(long[] arr) {
		for(long tmp : arr) {
			System.out.print(tmp + " ");
		}
		System.out.println();
	}

}
