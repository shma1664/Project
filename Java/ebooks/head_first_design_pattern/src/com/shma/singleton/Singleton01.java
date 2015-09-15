package com.shma.singleton;

/**
 * 饱汉式单例实现
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
