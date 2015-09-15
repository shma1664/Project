package com.shma.strategy.duck;

import com.shma.strategy.duck.fly.FlyBehavior;
import com.shma.strategy.duck.sing.SingBehavior;

/**
 * Ѽ�ӳ��� ����
 * @author admin
 *
 */
public abstract class Duck {

	private FlyBehavior flyBehavior;
	private SingBehavior singBehavior;
	
	protected String name;
	
	public Duck(String name) {
		this.name = name;
	}
	
	public void fly() {
		flyBehavior.fly(name);
	}
	
	public void sing() {
		singBehavior.sing(name);
	}
	
	/**
	 * ��̬�޸�Ѽ�ӵķ��з�ʽ
	 * @param flyBehavior
	 */
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	/**
	 * ��̬�޸�Ѽ�ӵ����з�ʽ
	 * @param singBehavior
	 */
	public void setSingBehavior(SingBehavior singBehavior) {
		this.singBehavior = singBehavior;
	}

	public abstract void display();
	
	public void swim() {
		System.out.println("���е�Ѽ�Ӷ�����Ӿ!");
	}
}
