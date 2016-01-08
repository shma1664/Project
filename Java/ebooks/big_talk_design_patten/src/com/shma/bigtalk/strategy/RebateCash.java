package com.shma.bigtalk.strategy;

/**
 * ¥Ú’€ ’∑—
 * @author admin
 *
 */
public class RebateCash implements ICash {

	//’€ø€
	private double moneyRebate = 1d;
	
	public RebateCash() {
		super();
	}

	public RebateCash(double moneyRebate) {
		super();
		this.moneyRebate = moneyRebate;
	}

	@Override
	public double acceptCash(double money) {
		// TODO Auto-generated method stub
		return money * moneyRebate;
	}

}
