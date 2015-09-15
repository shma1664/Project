package com.shma.strategy.duck.fly;

/**
 * 飞行行为具体的实现类：通过翅膀飞行
 * @author admin
 *
 */
public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly(String name) {
		System.out.println(name + " : 通过翅膀飞行!");
	}

}
