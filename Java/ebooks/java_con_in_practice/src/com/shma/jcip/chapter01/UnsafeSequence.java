package com.shma.jcip.chapter01;

import com.shma.jcip.annotation.NotThreadSafe;

/**
 * 非线程安全
 * @author admin
 *
 */
@NotThreadSafe
public class UnsafeSequence {

	private int value;
	
	/**
	 * 返回一个唯一值
	 * @return
	 */
	public int getNext() {
		return value++;
	}
}
