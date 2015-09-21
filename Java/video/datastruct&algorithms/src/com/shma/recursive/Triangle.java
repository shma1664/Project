package com.shma.recursive;

/**
 * Èý½ÇÔËËã
 * @author h p
 *
 */
public class Triangle {

	public static int getNumber(int n) {
		int total = 0;
		while(n > 0) {
			total = total + n;
			n--;
		}
		
		return total;
	}
	
	public static int getNumberByRecursive(int n) {
		if(n == 1) {
			return 1;
		}
		
		return n + getNumberByRecursive(n - 1);
	}
}
