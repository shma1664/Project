package com.shma.strategy.duck.fly;

/**
 * 飞行行为具体的实现类：通过火箭动力飞行
 * @author admin
 *
 */
public class FlyRocketPowered implements FlyBehavior {

	@Override
	public void fly(String name) {
		System.out.println(name + " : 通过火箭动力飞行!");
	}

}
