package com.shma.decorate.beverage;

import com.shma.decorate.Beverage;

public class Espresso extends Beverage {
  
	public Espresso() {
		description = "Espresso";
	}
  
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.99;
	}
}

