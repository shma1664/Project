package com.shma.singleton;

/**
 * ����ʽ����ʵ��
 * @author admin
 *
 */
public class Singleton01 {

	private static Singleton01 uniqueInstance = new Singleton01();
	
	private Singleton01() {
		
	}
	
	public static Singleton01 getInstance() {
		return uniqueInstance;
	} 
}
