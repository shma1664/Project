package com.shma.adapter.ducks;

import java.util.Random;

/**
 * Ñ¼×ÓÊÊÅäÆ÷£¬ÓÃÑ¼×ÓÈ¥ÊÊÅä»ğ¼¦
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
