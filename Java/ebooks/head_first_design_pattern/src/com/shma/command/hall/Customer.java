package com.shma.command.hall;

public class Customer {

	public static void main(String[] args) {
		Chef chef = new Chef();
		//Ҫһ�ݹ�������
		IOrder order = new GongBaojiDingOrder(chef);
		
		Waiter waiter = new Waiter();
		waiter.setOrder(order);
		
		waiter.createOrder();
	}
}
