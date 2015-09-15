package com.shma.spring.aopxml;

public interface Calculator<T> {

	public T add(T num1, T num2);
	
	public T sub(T num1, T num2);
	
	public T mult(T num1, T num2);
	
	public T div(T num1, T num2);
}
