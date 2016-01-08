package com.shma.bigtalk.simplefactory.calculator;

public interface IOperation<T> {

	public T getValue(T value1, T value2);
}
