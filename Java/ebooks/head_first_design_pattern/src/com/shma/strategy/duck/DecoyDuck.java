package com.shma.strategy.duck;

import com.shma.strategy.duck.fly.FlyNoWay;
import com.shma.strategy.duck.sing.SingNoWay;

public class DecoyDuck extends Duck {

	public DecoyDuck(String name) {
		super(name);
		this.setFlyBehavior(new FlyNoWay());
		this.setSingBehavior(new SingNoWay());
	}

	@Override
	public void display() {
		System.out.println("我是一只诱饵鸭");
	}

}
