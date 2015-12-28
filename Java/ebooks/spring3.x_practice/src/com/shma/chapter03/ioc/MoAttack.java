package com.shma.chapter03.ioc;

/**
 * 墨攻
 * @author admin
 *
 */
public class MoAttack {

	private Geli geli;
	
	public MoAttack() {
		super();
	}

	/**
	 * 构造器注入
	 * @param li
	 */
	public MoAttack(Geli geli) {
		this.geli = geli;
	}

	public Geli getGeli() {
		return geli;
	}

	/**
	 * 属性注入
	 * @param geli
	 */
	public void setGeli(Geli geli) {
		this.geli = geli;
	}
	
	public void cityGateAsk() {
		geli.responseAsk("来着墨离");
	}
}
