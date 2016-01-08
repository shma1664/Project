package com.shma.bigtalk.strategy;

import com.google.common.collect.ImmutableMap;

public class CashContext {

	private ICash cash;
	
	private static final ImmutableMap<Integer, String> immutableMap = 
			ImmutableMap.<Integer, String>builder()
						.put(1, "com.shma.bigtalk.strategy.NormalCash")
						.put(2, "com.shma.bigtalk.strategy.RebateCash")
						.put(3, "com.shma.bigtalk.strategy.ReturnCash")
						.build();
	
	public CashContext(String type) {
		if(type.equals("正常收费")) {
			cash = new NormalCash();
		} else if(type.equals("满300减100")) {
			cash = new ReturnCash(300, 100);
		} else if(type.equals("打8折")) {
			cash = new RebateCash(0.8d);
		} else {
			cash = new NormalCash();
		}
	}
	
	public double getResult(double money) {
		return cash.acceptCash(money);
	}
	
}
