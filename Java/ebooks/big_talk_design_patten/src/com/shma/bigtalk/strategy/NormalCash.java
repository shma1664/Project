package com.shma.bigtalk.strategy;

/**
 * �����շ�
 * @author admin
 *
 */
public class NormalCash implements ICash {

	@Override
	public double acceptCash(double money) {
		return money;
	}

}
