package com.shma.decorate.condiment;

import com.shma.decorate.Beverage;
import com.shma.decorate.CondimentDecorator;
 
public class Whip extends CondimentDecorator {

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
 
	public double cost() {
		return .10 + beverage.cost();
	}
}
