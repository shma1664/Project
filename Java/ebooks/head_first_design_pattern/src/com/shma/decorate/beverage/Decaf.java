package com.shma.decorate.beverage;

import com.shma.decorate.Beverage;

/**
 * 具体饮料类
 * @author admin
 *
 */
public class Decaf extends Beverage {

	public Decaf() {
		description = "Decaf Coffee";
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.05;
	}

}
