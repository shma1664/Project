package com.shma.stack;

/**
 * ջʵ�֣��Ƚ����
 * @author h p
 *
 */
public class MyStack {

	private long[] arr;
	
	//ջ��
	private int top;
	
	public MyStack() {
		this(5);
	}
	
	public MyStack(int maxSize) {
		arr = new long[maxSize];
		top = -1;
	}
	
	/**
	 * ��ջ
	 * @param value
	 */
	public void push(long value) {
		if(!isFull()) {
			arr[++top] = value;
		} else {
			throw new ArrayIndexOutOfBoundsException("����Խ��");
		}
	}
	
	/**
	 * ��ջ
	 * @return
	 */
	public long pop() {
		if(!isEmpty()) {
			return arr[top--];
		}
		
		throw new NullPointerException("��ָ���쳣");
	}
	
	/**
	 * �鿴
	 * @return
	 */
	public long peek() {
		return arr[top];
	}
	
	/**
	 * �Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return top == -1;
	}
	
	/**
	 * �Ƿ�����
	 * @return
	 */
	public boolean isFull() {
		return top == arr.length - 1;
	}
	
	
}
