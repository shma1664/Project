package com.shma.singleton.chocolate;

/**
 * 巧克力加工锅炉类
 * @author admin
 *
 */
public class ChocolateBoiler {

	//记录锅炉内原料是否为空
	private boolean empty = false;
	
	//记录锅炉内原料是否煮沸
	private boolean boiled = false;
	
	private volatile static ChocolateBoiler uniqueInstance = null;
	
	private ChocolateBoiler() {
		
	}
	
	public static ChocolateBoiler getInstance() {
		if(uniqueInstance == null) {
			synchronized (ChocolateBoiler.class) {
				if(uniqueInstance == null) {
					uniqueInstance = new ChocolateBoiler();
				}
			}
		}
		
		System.out.println("Returning instance of Chocolate Boiler");
		return uniqueInstance;
	}
	
	/**
	 * 装满锅炉
	 * 原料为空
	 */
	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
			// fill the boiler with a milk/chocolate mixture
		}
	}
 
	/**
	 * 排出成品
	 * 原料不能为空并且已经被煮沸
	 */
	public void drain() {
		if (!isEmpty() && isBoiled()) {
			// drain the boiled milk and chocolate
			empty = true;
		}
	}
 
	/**
	 * 煮沸方法
	 * 条件是锅炉原料不能为空并且没有被煮沸过
	 */
	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			// bring the contents to a boil
			boiled = true;
		}
	}
  
	public boolean isEmpty() {
		return empty;
	}
 
	public boolean isBoiled() {
		return boiled;
	}
}
