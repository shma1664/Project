package com.shma.jcip.chapter01;

import com.shma.jcip.annotation.NotThreadSafe;

/**
 * ���̰߳�ȫ
 * @author admin
 *
 */
@NotThreadSafe
public class UnsafeSequence {

	private int value;
	
	/**
	 * ����һ��Ψһֵ
	 * @return
	 */
	public int getNext() {
		return value++;
	}
}
