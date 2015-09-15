package com.shma.stack;

/**
 * 栈实现：先进后出
 * @author h p
 *
 */
public class MyStack {

	private long[] arr;
	
	//栈顶
	private int top;
	
	public MyStack() {
		this(5);
	}
	
	public MyStack(int maxSize) {
		arr = new long[maxSize];
		top = -1;
	}
	
	/**
	 * 入栈
	 * @param value
	 */
	public void push(long value) {
		if(!isFull()) {
			arr[++top] = value;
		} else {
			throw new ArrayIndexOutOfBoundsException("数组越界");
		}
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public long pop() {
		if(!isEmpty()) {
			return arr[top--];
		}
		
		throw new NullPointerException("空指针异常");
	}
	
	/**
	 * 查看
	 * @return
	 */
	public long peek() {
		return arr[top];
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return top == -1;
	}
	
	/**
	 * 是否满了
	 * @return
	 */
	public boolean isFull() {
		return top == arr.length - 1;
	}
	
	
}
