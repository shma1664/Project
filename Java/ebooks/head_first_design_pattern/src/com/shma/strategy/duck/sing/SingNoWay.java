package com.shma.strategy.duck.sing;

/**
 * ������Ϊ�����ʵ���ࣺ���ܷ�������
 * @author admin
 *
 */
public class SingNoWay implements SingBehavior {

	@Override
	public void sing(String name) {
		System.out.println(name + " : ���ܷ�������...");
	}

}
