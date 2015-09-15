package com.shma.strategy.duck.sing;

/**
 * 鸣叫行为具体的实现类：呱呱叫
 * @author admin
 *
 */
public class SingWithQuack implements SingBehavior {

	@Override
	public void sing(String name) {
		System.out.println(name + " : 呱呱叫...");
	}

}
