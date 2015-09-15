package com.shma.spring.proxy;

public class StaticProxyUtil implements Calculator<Integer> {

	private IntegerCalculator calculator;
	
	public StaticProxyUtil(IntegerCalculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public Integer add(Integer num1, Integer num2) {
		return calculator.add(num1, num2);
	}

	@Override
	public Integer sub(Integer num1, Integer num2) {
		return calculator.sub(num1, num2);
	}

	@Override
	public Integer mult(Integer num1, Integer num2) {
		return calculator.mult(num1, num2);
	}

	@Override
	public Integer div(Integer num1, Integer num2) {
		return calculator.div(num1, num2);
	}
 
}
