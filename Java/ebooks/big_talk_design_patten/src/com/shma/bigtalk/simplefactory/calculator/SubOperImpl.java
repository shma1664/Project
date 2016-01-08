package com.shma.bigtalk.simplefactory.calculator;

public class SubOperImpl implements IOperation<Double> {

	@Override
	public Double getValue(Double value1, Double value2) {
		return value1 - value2;
	}

}
