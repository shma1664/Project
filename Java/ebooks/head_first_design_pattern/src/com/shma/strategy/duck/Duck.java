package com.shma.strategy.duck;

import com.shma.strategy.duck.fly.FlyBehavior;
import com.shma.strategy.duck.sing.SingBehavior;

/**
 * 鸭子超类 策略
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
	 * 动态修改鸭子的飞行方式
	 * @param flyBehavior
	 */
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	/**
	 * 动态修改鸭子的鸣叫方式
	 * @param singBehavior
	 */
	public void setSingBehavior(SingBehavior singBehavior) {
		this.singBehavior = singBehavior;
	}

	public abstract void display();
	
	public void swim() {
		System.out.println("所有的鸭子都会游泳!");
	}
}
