package com.shma.strategy.duck.sing;

/**
 * 鸣叫行为具体的实现类：吱吱叫
 * @author admin
 *
 */
public class SingWithSqueak implements SingBehavior {

	@Override
	public void sing(String name) {
		System.out.println(name + " : 吱吱叫...");
	}

}
