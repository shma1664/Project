package com.shma.array;

import java.lang.reflect.Array;

/**
 * �Զ����װ����
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
	 * ����Ԫ��
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
	 * ��ʾԪ��
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
			throw new ArrayIndexOutOfBoundsException("����Խ��");
		}
		
		T value = array[index];
		
		for(int i=index; i<elements; ++i) {
			array[i] = array[i+1];
		}
		elements--;
		
		return value;
	}
	
	/**
	 * ��������
	 * @param index
	 * @param value
	 */
	public T update(int index, T value) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException("����Խ��");
		}
		T oldValue = array[index];
		array[index] = value;
		
		return oldValue;
	}
	
	/**
	 * ������������
	 * @param index
	 * @return
	 */
	public T get(int index) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException("����Խ��");
		}
		
		return array[index];
	}
	
	/**
	 * ����Ԫ��λ��
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
	 * ���ַ�����
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
