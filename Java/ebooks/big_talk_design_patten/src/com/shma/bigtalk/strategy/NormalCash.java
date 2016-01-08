package com.shma.bigtalk.strategy;

/**
 * 正常收费
 * @author admin
 *
 */
public class NormalCash implements ICash {

	@Override
	public double acceptCash(double money) {
		return money;
	}

}
