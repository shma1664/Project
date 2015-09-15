package com.shma.decorate;

/**
 * 被装饰者和装饰者公共的抽象类,被装饰者和装饰者都继承这个抽象类
 * @author admin
 *
 */
public abstract class Beverage {

	//饮料描述
	protected String description = "Unknown Beverage";
	
	public String getDescription() {
		return description;
	}
	
	/**
	 * 计算饮料价格
	 * @return
	 */
	public abstract double cost();
}
