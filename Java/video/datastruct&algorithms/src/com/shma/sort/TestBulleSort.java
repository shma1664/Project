package com.shma.sort;

import org.junit.Test;

public class TestBulleSort {

	@Test
	public void testSmall2Big() {
		
		long[] array = {4, 2, 1, 5, 8, 3, 9, 6, 7};
		
		System.out.print("����ǰ��");
		printArray(array);
		BubbleSort.bubbleSortForSmall2Big(array);
		System.out.print("�����");
		printArray(array);
	}
	
	
	@Test
	public void testBig2Small() {
		
		long[] array = {4, 2, 1, 5, 8, 3, 9, 6, 7};
		
		System.out.print("����ǰ��");
		printArray(array);
		BubbleSort.bubbleSortForBig2Small(array);
		System.out.print("�����");
		printArray(array);
	}
	
	private void printArray(long[] array) {
		System.out.print("[");
		for(long a : array) {
			System.out.print(a + " ");
		}
		System.out.println("]");
		
	}

}
