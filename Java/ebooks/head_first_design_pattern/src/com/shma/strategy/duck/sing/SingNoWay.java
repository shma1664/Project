package com.shma.strategy.duck.sing;

/**
 * 鸣叫行为具体的实现类：不能发出声音
 * @author admin
 *
 */
public class SingNoWay implements SingBehavior {

	@Override
	public void sing(String name) {
		System.out.println(name + " : 不能发出声音...");
	}

}
