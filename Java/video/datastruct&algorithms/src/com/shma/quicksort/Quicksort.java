package com.shma.quicksort;

/**
 * ��������
 * 
 * @author h p
 *
 */
public class Quicksort {

	public static int getMiddle(long[] arr, int begin, int end) {
		long keyword = arr[end];
		while(true) {
			for(; begin<arr.length; ++begin) {
				if(arr[begin] >= keyword) {
					break;
				}
			}
			end = end - 1;
			for(; end>0; --end) {
				if(arr[end] < keyword) {
					break;
				}
			}
			
			if(begin >= end) {
				break;
			} else {
				long tmp = arr[begin];
				arr[begin] = arr[end];
				arr[end] = tmp;
			}
		}
		
		long tmp = arr[begin];
		arr[begin] = arr[end];
		arr[end] = tmp;
		
		return begin;
	}
	
	public static void display(long[] arr) {
		for(long value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	
	public static void sort(long[] arr, int begin, int end) {
		
		if(begin >= end) {
			return;
		}

		int middle = getMiddle(arr, begin, end);
		//����߽��еݹ�
		sort(arr, begin, middle - 1);
		//���ұ߽��еݹ�
		sort(arr, middle + 1, end);
	}
}
