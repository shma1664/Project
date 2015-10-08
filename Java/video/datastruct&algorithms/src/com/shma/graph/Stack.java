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
	 * 入栈
	 * @param value
	 */
	public void push(T value) {
		if(!isFull()) {
			array[++top] = value;
		} else {
			throw new ArrayIndexOutOfBoundsException("数组越界");
		}
		
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public T pop() {
		if(isEmpty()) {
			throw new NullPointerException("数组为空");
		}
		return array[top--];
	}
	
	/**
	 * 查看栈顶
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
