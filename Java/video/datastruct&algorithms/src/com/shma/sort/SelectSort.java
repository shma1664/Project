package com.shma.sort;
/**
 * —°‘Ò∑®≈≈–Ú
 * @author h p
 *
 */
public class SelectSort {

	public static void selectSortByBig2Small(long[] array) {
		
		int index = 0;
		
		for(int i=0; i<array.length; ++i) {
			index = i;
			
			for(int j = i; j <array.length; ++j) {
				if(array[j] > array[index]) {
					index = j;
				}
			}
			
			long tmpValue = array[index];
			array[index] = array[i];
			array[i] = tmpValue;
		}
		
	}
	
	
	public static void selectSortBySmall2Big(long[] array) {
		
		int index = 0;
		
		for(int i=array.length-1; i>=0; --i) {
			
			index = i;
			
			for(int j=i; j>=0; --j) {
				if(array[j] > array[index]) {
					index = j;
				}
			}
			
			long tmpValue = array[index];
			array[index] = array[i];
			array[i] = tmpValue;
		}
	}
}
