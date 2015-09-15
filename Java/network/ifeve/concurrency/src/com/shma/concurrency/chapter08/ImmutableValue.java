package com.shma.concurrency.chapter08;

/**
 * 创建不可变成员变量解决线程安全问题
 * 	请注意:1)ImmutableValue类的成员变量value是通过构造函数赋值的，并且在类中没有set方法。
 *  	 2)这意味着一旦ImmutableValue实例被创建，value变量就不能再被修改，这就是不可变性。
 *  	 3)但你可以通过getValue()方法读取这个变量的值。
 * @author admin
 *
 */
public class ImmutableValue {

	private int value;
	
	public ImmutableValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	/**
	 * 如果你需要对ImmutableValue类的实例进行操作，可以通过得到value变量后创建一个新的实例来实现
	 * 下面是一个对value变量进行加法操作的示例:
	 * @param newValue
	 * @return
	 */
	public ImmutableValue add(int newValue) {
		return new ImmutableValue(this.value + newValue);
	}
}
