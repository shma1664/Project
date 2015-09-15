package com.shma.adapter.ducks;

import java.util.Random;

/**
 * Ѽ������������Ѽ��ȥ�����
 * @author admin
 *
 */
public class DuckAdapter implements Turkey {

	private Duck duck;
	private Random random = new Random();
	
	public DuckAdapter(Duck duck) {
		this.duck = duck;
	}

	@Override
	public void gobble() {
		duck.quack();
	}

	@Override
	public void fly() {
		duck.fly();
	}


}
