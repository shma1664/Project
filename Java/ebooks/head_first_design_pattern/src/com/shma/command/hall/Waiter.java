package com.shma.command.hall;

/**
 * ����Ա
 * @author admin
 *
 */
public class Waiter {

	private IOrder order;

	public IOrder getOrder() {
		return order;
	}

	public void setOrder(IOrder order) {
		this.order = order;
	}
	
	public void createOrder() {
		order.createOrder();
	}
}
