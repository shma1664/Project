package com.shma.quicksort;

/**
 * ��������
 * 
 * @author h p
 *
 */
public class Quicksort {

	/**
	 * ����keyword�������ҷ��У�����Ĭ��Ϊ���ұߵ���
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
			//���
			for(; left <= right; ++left) {
				if(arr[left] > keyword) {
					break;
				}
			}
			
			//�ұ�
			for(; right >= left; --right) {
				if(arr[right] < keyword) {
					break;
				}
			}
			
			if(left >= right) {
				break;
			} else {
				//��������
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
		
		//��ߵݹ�����
		sort(arr, begin, middle - 1);
		
		//�ұߵݹ�����
		sort(arr, middle + 1, end);
	}
	
	public static void display(long[] arr) {
		for(long value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}
