package com.shma.strategy.duck.fly;

/**
 * 飞行行为具体的实现类：没有飞行的能力
 * @author admin
 *
 */
public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly(String name) {
		System.out.println(name + " : 无法飞行!");
	}

}
