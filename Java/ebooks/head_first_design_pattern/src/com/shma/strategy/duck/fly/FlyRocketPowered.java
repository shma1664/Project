package com.shma.strategy.duck.fly;

/**
 * ������Ϊ�����ʵ���ࣺͨ�������������
 * @author admin
 *
 */
public class FlyRocketPowered implements FlyBehavior {

	@Override
	public void fly(String name) {
		System.out.println(name + " : ͨ�������������!");
	}

}
