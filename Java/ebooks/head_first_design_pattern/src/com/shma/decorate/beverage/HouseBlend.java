package com.shma.decorate.beverage;

import com.shma.decorate.Beverage;

public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .89;
	}
}

