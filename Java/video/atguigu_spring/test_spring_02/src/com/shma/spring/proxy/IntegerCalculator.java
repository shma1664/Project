package com.shma.spring.proxy;

/**
 * ���ͼ�����
 * @author h p
 *
 */
public class IntegerCalculator implements Calculator<Integer> {

	@Override
	public Integer add(Integer num1, Integer num2) {
		int result = num1 + num2;
		return result;
	}

	@Override
	public Integer sub(Integer num1, Integer num2) {
		int result = num1 - num2;
		return result;
	}

	@Override
	public Integer mult(Integer num1, Integer num2) {
		int result = num1 * num2;
		return result;
	}

	@Override
	public Integer div(Integer num1, Integer num2) {
		int result = num1 / num2;
		return result;
	}

}
