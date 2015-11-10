package com.shma.common.lang;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

public class TestArrayUtils {

	public static void main(String[] args) {
		int[] array01 = {1, 2, 3, 4, 5};
		int[][] array02 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
		Object[][] arrayMap = {{"A", new Double(10)},
				{"B", new Double(10)},
				{"C", new Double(20)},
				{"D", new Double(30)},
				{"E", new Double(40)},
				{"F", new Double(50)}};
		
		System.out.println(ArrayUtils.toString(array01));
		System.out.println(ArrayUtils.toString(array02));
		System.out.println(ArrayUtils.toString(arrayMap));
		
		int[] array03 = ArrayUtils.add(array01, 6);
		System.out.println(ArrayUtils.toString(array03)); //{1,2,3,4,5,6}
		
		System.out.println(ArrayUtils.contains(array01, 4));
		System.out.println(ArrayUtils.contains(array01, 6));
		
		System.out.println(ArrayUtils.indexOf(array01, 20));
		System.out.println(ArrayUtils.lastIndexOf(array01, 2));
		
		int[] array04 = ArrayUtils.clone(array01);
		System.out.println(array01 == array04);
		System.out.println(ArrayUtils.toString(array04));
		
		int[] array05 = ArrayUtils.subarray(array01, 1, 3);
		System.out.println(ArrayUtils.toString(array05));
		
		ArrayUtils.reverse(array01);
		System.out.println(ArrayUtils.toString(array01));
		
		Map<Object, Object> map = ArrayUtils.toMap(arrayMap);
		System.out.println(map.get("C"));
		
	}
}
