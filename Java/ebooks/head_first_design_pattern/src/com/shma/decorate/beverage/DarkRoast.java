package com.shma.decorate.beverage;

import com.shma.decorate.Beverage;

/**
 * ����������
 * @author admin
 *
 */
public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "Dark Roast Coffee";
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 0.99;
	}

}
