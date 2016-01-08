package com.shma.bigtalk.strategy;

/**
 * Âú¼õ £¬·µÀû
 * @author admin
 *
 */
public class ReturnCash implements ICash {

	private double moneyCondition = 0.0d;
	private double moneyReturn = 0.0d;
	
	public ReturnCash() {
		super();
	}

	public ReturnCash(double moneyCondition, double moneyReturn) {
		super();
		this.moneyCondition = moneyCondition;
		this.moneyReturn = moneyReturn;
	}

	@Override
	public double acceptCash(double money) {
		if(moneyCondition <= money) {
			return money - Math.floor(money / moneyCondition) * moneyReturn;
		}
		return money;
	}

}
