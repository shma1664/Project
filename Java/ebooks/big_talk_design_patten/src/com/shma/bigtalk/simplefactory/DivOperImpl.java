package com.shma.bigtalk.simplefactory;

public class DivOperImpl implements IOperation<Double> {

	@Override
	public Double getValue(Double value1, Double value2) {
		if(value2 == 0) {
			return -1d;
		}
		
		return value1 / value2;
	}

}
