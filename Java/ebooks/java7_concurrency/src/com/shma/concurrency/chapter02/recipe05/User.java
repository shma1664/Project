package com.shma.concurrency.chapter02.recipe05;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class User {

	private Amount amount;
	
	private String name;
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
	
	public User(Amount amount, String name) {
		super();
		this.amount = amount;
		this.name = name;
	}

	public double get() {
		lock.readLock().lock();
		double money = amount.getAmount();
		System.out.println("����" + name + "���ڲ�ѯ" + amount.getOid() + "�˻�����ǰ���Ϊ" + money);
		try {
			return money;
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public double put(double money) {
		lock.writeLock().lock();
		
		try {
			//ִ���ֽ�ҵ��  
			System.out.println("д��" + name + "���ڲ���" + amount.getOid() + "�˻������Ϊ" + money +"����ǰ���Ϊ" + amount.getAmount());  
            amount.setAmount(amount.getAmount() + money); 
            System.out.println("д��" + name + "����" + amount.getOid() + "�˻��ɹ������Ϊ" + money +"����ǰ���Ϊ" + amount.getAmount()); 
		} finally {
			lock.writeLock().unlock();
		}
		
		return amount.getAmount();
	}
}
