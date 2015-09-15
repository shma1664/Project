package com.shma.decorate;

/**
 * 佐料装饰者抽象类
 * 所有的具体佐料对象集成这个抽象类
 * 这个抽象类又集成自Beverage抽象类
 * @author admin
 *
 */
public abstract class CondimentDecorator extends Beverage {

	
	protected Beverage beverage;

	/**
	 * 佐料具体实现类需要重写描述这个方法
	 */
	public abstract String getDescription();
	
}
