package com.shma.chapter01.bank;

public class Bank {

	private String name;
	private int money;
	
	public Bank(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	
	public synchronized int deposit(int m) {
		money += m;
		System.out.println(name + "��ֵ" + m + "Ԫ");
		return money;
	}
	
	public synchronized int withdraw(int m) {
		
		if(money < 0 || m > money) {
			throw new MoneyExecption("����");
		}
		
		money -= m;
		System.out.println(name + "ȡ��" + m + "Ԫ����" + money);
		return money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}
