package com.shma.strategy.duck.fly;

/**
 * ������Ϊ�����ʵ���ࣺû�з��е�����
 * @author admin
 *
 */
public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly(String name) {
		System.out.println(name + " : �޷�����!");
	}

}
