package com.shma.strategy.duck;

import com.shma.strategy.duck.fly.FlyNoWay;
import com.shma.strategy.duck.sing.SingWithSqueak;

public class ModelDuck extends Duck {

	public ModelDuck(String name) {
		super(name);
		this.setFlyBehavior(new FlyNoWay());
		this.setSingBehavior(new SingWithSqueak());
	}

	@Override
	public void display() {
		System.out.println("我是一只模型鸭");
	}

}
