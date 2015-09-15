package com.shma.queue;

/**
 * ����ʵ�֣��Ƚ��ȳ�
 * @author h p
 *
 */
public class MyQueue {

	private long[] arr;
	
	//Ԫ�ظ���
	private int elements;
	
	//��ͷ
	private int first;
	
	//��β
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
	 * �Ӷ�β��������
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
	 * �Ƴ����ݣ���ͷ�Ƴ�
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
	 * �鿴����ͷ��ʼ
	 * @return
	 */
	public long peek() {
		return arr[first];
	}
	
	/**
	 * �Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return elements == 0;
	}
	
	public boolean isFull() {
		return elements == arr.length;
	}
}
