package com.shma.sort;

/**
 * ≤Â»Î≈≈–Ú
 * @author h p
 *
 */
public class InsertSort {

	public static void insertSortBySmall2Big(long[] array) {
		
		long tmpValue = 0L;
		
		for(int i=1; i<array.length; ++i) {
			tmpValue = array[i];
			int j = i - 1;
			for(; j>=0; --j) {
				if(array[j] > tmpValue) {
					array[j+1] = array[j];
				} else {
					break;
				}
			}
			array[j+1] = tmpValue;
		}
	}
	
	public static void insertSortByBig2Small(long[] array) {
		long tmpValue = 0L;
		for(int i=array.length-2; i>=0; --i) {
			tmpValue = array[i];
			int j = i + 1;
			for(; j<=array.length-1; ++j)  {
				if(array[j] > tmpValue) {
					array[j-1] = array[j];
				} else {
					break;
				}
			}
			array[j-1] = tmpValue;
		}
	}
}
