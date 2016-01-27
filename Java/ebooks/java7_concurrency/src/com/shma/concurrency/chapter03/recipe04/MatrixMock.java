package com.shma.concurrency.chapter03.recipe04;

/**
 * 矩阵
 * @author admin
 *
 */
public class MatrixMock {

	private int[][] data;

	public MatrixMock(int size, int length, int number) {
		int counter = 0;
		data = new int[size][length];
		
		//随机赋值
		for(int i=0; i<size; ++i) {
			for(int j=0; j<length; ++j) {
				int value = (int) (Math.random() * 100);
				data[i][j] = value;
				if(value == number) {
					counter++;
				}
			}
		}
		
		System.out.printf("Mock: There are %d ocurrences of number in generated data.\n", counter, number);
	}
	
	/**
	 * 获取行数据
	 * @param row
	 * @return
	 */
	public int[] getRow(int row) {
		if(row >= 0 && row < data.length) {
			return data[row];
		}
		
		return null;
	}
}
