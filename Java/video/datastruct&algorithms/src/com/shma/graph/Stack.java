package com.shma.graph;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T> {

	private T[] array;
	
	private int top;
	
	public Stack(Class clazz, int size) {
		array = (T[]) Array.newInstance(clazz, size);
		top = -1;
	}
	
	/**
	 * ��ջ
	 * @param value
	 */
	public void push(T value) {
		if(!isFull()) {
			array[++top] = value;
		} else {
			throw new ArrayIndexOutOfBoundsException("����Խ��");
		}
		
	}
	
	/**
	 * ��ջ
	 * @return
	 */
	public T pop() {
		if(isEmpty()) {
			throw new NullPointerException("����Ϊ��");
		}
		return array[top--];
	}
	
	/**
	 * �鿴ջ��
	 * @return
	 */
	public T peek() {
		return array[top];
	}
	
	public boolean isFull() {
		return array.length <= top ? true : false;
	}
	
	public boolean isEmpty() {
		return top < 0 ? true : false;
	}
}
