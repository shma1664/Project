package com.shma.array;

import java.lang.reflect.Array;

/**
 * 自定义封装数组
 * @author h p
 *
 */
public class MyArray<T> {

	private T[] array;
	
	private int elements = 0;
	
	public MyArray(Class<T> clazz) {
		this(50, clazz);
	}
	
	public MyArray(int size, Class<T> clazz) {
		array = (T[]) Array.newInstance(clazz, size);
	}
	
	/**
	 * 插入元素
	 * @param value
	 */
	public void insert(T value) {
		array[elements] = value;
		elements++;
	}
	
	public void insertByOrder(T value) {
		int i;
		for(i=0 ;i<elements; ++i) {
			if(Double.valueOf(String.valueOf(array[i])) > Double.valueOf(String.valueOf(value))) {
				break;
			}
		}
		
		for(int j = elements; j > i; --j) {
			array[j] = array[j-1];
		}
		
		array[i] = value;
		elements++;
	}
	
	/**
	 * 显示元素
	 */
	public void display() {
		System.out.print("[");
		for(int i=0; i<elements; ++i) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
	}
	
	public T del(int index) {
		if(index < 0 || index >= elements) {
			throw new ArrayIndexOutOfBoundsException("数组越界");
		}
		
		T value = array[index];
		
		for(int i=index; i<elements; ++i) {
			array[i] = array[i+1];
		}
		elements--;
		
		return value;
	}
	
	/**
	 * 更新数据
	 * @param index
	 * @param value
	 */
	public T update(int index, T value) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException("数组越界");
		}
		T oldValue = array[index];
		array[index] = value;
		
		return oldValue;
	}
	
	/**
	 * 根据索引查找
	 * @param index
	 * @return
	 */
	public T get(int index) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException("数组越界");
		}
		
		return array[index];
	}
	
	/**
	 * 查找元素位置
	 * @param value
	 * @return
	 */
	public int search(T value) {
		int index = 0;
		
		for(index=0; index<elements; ++index) {
			if(array[index] == value) {
				return index;
			}
		}
		
		return -1;
	}
	
	/**
	 * 二分法查找
	 * @param value
	 * @return
	 */
	public int binarySearch(T value) {
		int low = 0;
		int pow = elements;
		int middle = 0;
		while(true) {
			middle = (pow + low) / 2;
			if(array[middle] == value) {
				return middle;
			}
			
			if(low >= pow) {
				return -1;
			}
			
			if(Double.valueOf(String.valueOf(array[middle])) > Double.valueOf(String.valueOf(value))) {
				pow = middle;
			} else {
				low = middle;
			}
		}
	}
}
