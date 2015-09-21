package com.shma.sort;

/**
 * 希尔排序
 * @author h p
 *
 */
public class ShellSort {

	public static void sort(long[] arr) {
		
		//计算最大间隔
		int h = 1;
		while(h < arr.length / 3) {
			h = h / 3 + 1;
		}
		System.out.println("数组长度为:" + arr.length + ", 最大间隔因子：" + h);
		long tmp = 0L;
		for(int i=h; i<arr.length; ++i) {
			tmp = arr[h];
			int j = i;
			while(j >= 0) {
			}
		}
	}
}
