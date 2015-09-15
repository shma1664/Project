package com.shma.sort;

/**
 * ð�ݷ�����
 * @author h p
 *
 */
public class BubbleSort {

	/**
	 * ��С����
	 * @param array
	 * @return
	 */
	public static void bubbleSortForSmall2Big(long[] array) {
		for(int i=0; i<array.length; ++i) {
			for(int j=array.length-1; j>i; --j) {
				if(array[j] < array[j-1]) {
					long tmpValue = array[j];
					array[j] = array[j-1];
					array[j-1] = tmpValue;
				}
			}
		}
	}
	
	public static void bubbleSortForBig2Small(long[] array) {
		for(int i=array.length-1; i>=0; --i) {
			for(int j=0; j<i; ++j) {
				if(array[j] < array[j+1]) {
					long tmpValue = array[j];
					array[j] = array[j+1];
					array[j+1] = tmpValue;
				}
 			}
		}
	}
}
