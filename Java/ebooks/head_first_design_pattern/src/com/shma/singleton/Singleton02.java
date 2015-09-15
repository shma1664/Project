package com.shma.singleton;

/**
 * ����ʽ����˫������
 * @author admin
 *
 */
public class Singleton02 {

	private volatile static Singleton02 uniqueInstance = null;
	
	private Singleton02() {
		
	}
	
	public static Singleton02 getInstance() {
		if(uniqueInstance == null) {
			synchronized (Singleton02.class) {
				if(uniqueInstance == null) {
					uniqueInstance = new Singleton02();
				}
			}
		}
		
		return uniqueInstance;
	}
}
