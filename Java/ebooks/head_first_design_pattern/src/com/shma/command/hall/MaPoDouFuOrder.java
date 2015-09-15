package com.shma.command.hall;

public class MaPoDouFuOrder implements IOrder {

	private Chef chef;
	
	public MaPoDouFuOrder(Chef chef) {
		this.chef = chef;
	}
	
	@Override
	public void createOrder() {
		chef.createMaPoDouFu();
	}

}
