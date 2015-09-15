package com.shma.command.hall;

public class GongBaojiDingOrder implements IOrder {

	private Chef chef;
	
	public GongBaojiDingOrder(Chef chef) {
		this.chef = chef;
	}
	
	@Override
	public void createOrder() {
		chef.createGongBaojiDing();
	}

}
