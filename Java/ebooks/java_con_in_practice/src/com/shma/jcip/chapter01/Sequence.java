package com.shma.jcip.chapter01;

import com.shma.jcip.annotation.ThreadSafe;

/**
 * �̰߳�ȫ
 * @author admin
 *
 */
@ThreadSafe
public class Sequence {

	private int nextValue;
	
	public synchronized int getNext() {
		return nextValue++;
	}
} 
