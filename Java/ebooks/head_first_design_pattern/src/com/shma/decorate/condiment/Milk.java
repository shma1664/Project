package com.shma.decorate.condiment;

import com.shma.decorate.Beverage;
import com.shma.decorate.CondimentDecorator;

/**
 * 佐料具体实现类
 * @author admin
 *
 */
public class Milk extends CondimentDecorator {

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	@Override
	public double cost() {
		return .10 + beverage.cost() ;
	}

}
