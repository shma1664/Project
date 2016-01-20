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
		System.out.println("读：" + name + "正在查询" + amount.getOid() + "账户，当前金额为" + money);
		try {
			return money;
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public double put(double money) {
		lock.writeLock().lock();
		
		try {
			//执行现金业务  
			System.out.println("写：" + name + "正在操作" + amount.getOid() + "账户，金额为" + money +"，当前金额为" + amount.getAmount());  
            amount.setAmount(amount.getAmount() + money); 
            System.out.println("写：" + name + "操作" + amount.getOid() + "账户成功，金额为" + money +"，当前金额为" + amount.getAmount()); 
		} finally {
			lock.writeLock().unlock();
		}
		
		return amount.getAmount();
	}
}
