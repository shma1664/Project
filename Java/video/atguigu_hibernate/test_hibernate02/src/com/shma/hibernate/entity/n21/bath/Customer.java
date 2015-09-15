package com.shma.hibernate.entity.n21.bath;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private int customerId;
	
	private String customerName;
	
	/**
	 * 1、声明集合需要使用接口，因为hibernate延迟加载，在获取集合的时候是获取到的hibernate内部集合实例
	 * 2、需要把集合进行初始化, 可以防止发生空指针异常
	 */
	private Set<Order> orders = new HashSet<>();

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
