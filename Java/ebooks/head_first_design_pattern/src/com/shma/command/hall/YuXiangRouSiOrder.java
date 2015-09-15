package com.shma.command.hall;

public class YuXiangRouSiOrder implements IOrder {

	private Chef chef;
	
	public YuXiangRouSiOrder(Chef chef) {
		this.chef = chef;
	}
	
	@Override
	public void createOrder() {
		chef.createYuXiangQieZi();
	}

}
