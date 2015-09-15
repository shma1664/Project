package com.shma.reflection.array;

import java.lang.reflect.Array;

public class TestArray<T> {

	public static void main(String[] args) {
		
		TestArray<Integer> testArray = new TestArray<Integer>();
		
		Integer[] arrays = testArray.createArray(Integer.class, 10);
		Array.set(arrays, 0, 10);
		Array.set(arrays, 1, 6);
		Array.set(arrays, 2, 19);
		Array.set(arrays, 3, 21);
		
		System.out.println(Array.get(arrays, 0));
		
		System.out.print("[");
		for(Integer value : arrays) {
			System.out.print(value + " ");
		}
		System.out.println("]");
		
		
		String[] arrayStrings = new String[19];
		
		Class<?> clazz = arrayStrings.getClass();
		
		System.out.println(clazz.getComponentType().getName());
	}
	
	private T[] createArray(Class<T> clazz, int size) {
		
		return (T[]) Array.newInstance(clazz, size);
	}
}
