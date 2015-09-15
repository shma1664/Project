package com.shma.decorate.condiment;

import com.shma.decorate.Beverage;
import com.shma.decorate.CondimentDecorator;

public class Soy extends CondimentDecorator {

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + beverage.cost();
	}
}
