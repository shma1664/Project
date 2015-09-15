package com.shma.queue;

/**
 * 队列实现，先进先出
 * @author h p
 *
 */
public class MyQueue {

	private long[] arr;
	
	//元素个数
	private int elements;
	
	//对头
	private int first;
	
	//队尾
	private int end;
	
	public MyQueue() {
		this(5);
	}
	
	public MyQueue(int maxSize) {
		arr = new long[maxSize];
		first = 0;
		end = -1;
		elements = 0;
	}
	
	/**
	 * 从队尾插入数据
	 * @param value
	 */
	public void insert(long value) {
		
		if(end == arr.length - 1) {
			end = -1;
		}
		
		arr[++end] = value;
		elements++;
	}
	
	/**
	 * 移除数据，从头移除
	 * @return
	 */
	public long remove() {
		if(first == arr.length) {
			first = 0;
		}
		elements--;
		return arr[first++];
	}
	
	/**
	 * 查看，从头开始
	 * @return
	 */
	public long peek() {
		return arr[first];
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return elements == 0;
	}
	
	public boolean isFull() {
		return elements == arr.length;
	}
}
