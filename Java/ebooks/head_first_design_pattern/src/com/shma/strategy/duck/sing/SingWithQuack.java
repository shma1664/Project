package com.shma.strategy.duck.sing;

/**
 * ������Ϊ�����ʵ���ࣺ���ɽ�
 * @author admin
 *
 */
public class SingWithQuack implements SingBehavior {

	@Override
	public void sing(String name) {
		System.out.println(name + " : ���ɽ�...");
	}

}
