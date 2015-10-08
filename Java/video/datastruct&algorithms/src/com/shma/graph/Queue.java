package com.shma.graph;

import java.lang.reflect.Array;

public class Queue<T> {

	private T[] array;
	
	private int element;
	
	private int head;
	private int tail;
	
	public Queue(Class<?> clazz, int size) {
		array = (T[]) Array.newInstance(clazz, size);
		head = 0;
		tail = -1;
		element = 0;
	}
	
	public void insert(T value) {
		if(tail == array.length - 1) {
			tail = -1;
		}
		
		array[++tail] = value;
		element++;
	}
	
	public T remove() {
		if(head == array.length) {
			head = 0;
		}
		element--;
		return array[head++];
	}
	
	public T peek() {
		return array[head];
	}
	
	public boolean isFull() {
		return element >= array.length ? true : false;
	}
	
	public boolean isEmpty() {
		return element <= 0 ? true : false;
	}
}
