package com.shma.decorate.condiment;

import com.shma.decorate.Beverage;
import com.shma.decorate.CondimentDecorator;

public class Mocha extends CondimentDecorator {
 
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
 
	public double cost() {
		return .20 + beverage.cost();
	}
}
