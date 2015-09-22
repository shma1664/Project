package com.shma.quicksort;

/**
 * 快速排序
 * 
 * @author h p
 *
 */
public class Quicksort {

	/**
	 * 按照keyword进行左右分列，因子默认为最右边的数
	 * @param arr
	 * @param begin
	 * @param end
	 * @param keyword
	 * @return
	 */
	public static int getMiddle(long[] arr, int begin, int end) {
		int left = begin;
		int right = end - 1;
		long keyword = arr[end];
		
		while(true) {
			//左边
			for(; left <= right; ++left) {
				if(arr[left] > keyword) {
					break;
				}
			}
			
			//右边
			for(; right >= left; --right) {
				if(arr[right] < keyword) {
					break;
				}
			}
			
			if(left >= right) {
				break;
			} else {
				//交换数据
				long tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
		}
		
		long tmp = arr[left];
		arr[left] = arr[end];
		arr[end] = tmp;
		
		return left;
	}
	
	public static void sort(long[] arr, int begin, int end) {
		if(begin >= end) {
			return;
		}
		
		int middle = getMiddle(arr, begin, end);
		
		//左边递归排序
		sort(arr, begin, middle - 1);
		
		//右边递归排序
		sort(arr, middle + 1, end);
	}
	
	public static void display(long[] arr) {
		for(long value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}
