package com.shma.sort;

/**
 * ϣ������
 * @author h p
 *
 */
public class ShellSort {

	public static void sort(long[] arr) {
		
		//���������
		int h = 1;
		while(h < arr.length / 3) {
			h = h / 3 + 1;
		}
		System.out.println("���鳤��Ϊ:" + arr.length + ", ��������ӣ�" + h);
		long tmp = 0L;
		for(int i=h; i<arr.length; ++i) {
			tmp = arr[h];
			int j = i;
			while(j >= 0) {
			}
		}
	}
}
