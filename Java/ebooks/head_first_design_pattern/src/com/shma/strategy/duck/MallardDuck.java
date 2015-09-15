package com.shma.strategy.duck;

import com.shma.strategy.duck.fly.FlyWithWings;
import com.shma.strategy.duck.sing.SingWithQuack;

public class MallardDuck extends Duck {

	public MallardDuck(String name) {
		super(name);
		this.setFlyBehavior(new FlyWithWings());
		this.setSingBehavior(new SingWithQuack());
	}

	@Override
	public void display() {
		System.out.println("我是一只绿头鸭");
	}

}
