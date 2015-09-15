package com.shma.hibernate.entity.n21.bath;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private int customerId;
	
	private String customerName;
	
	/**
	 * 1������������Ҫʹ�ýӿڣ���Ϊhibernate�ӳټ��أ��ڻ�ȡ���ϵ�ʱ���ǻ�ȡ����hibernate�ڲ�����ʵ��
	 * 2����Ҫ�Ѽ��Ͻ��г�ʼ��, ���Է�ֹ������ָ���쳣
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
