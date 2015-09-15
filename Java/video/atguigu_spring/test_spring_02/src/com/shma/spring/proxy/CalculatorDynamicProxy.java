package com.shma.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorDynamicProxy implements InvocationHandler {

	private Object object;
	
	public CalculatorDynamicProxy(Object object) {
		this.object = object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("方法执行之前：" + method.getName());
		method.invoke(object, args);
		System.out.println("方法执行之后：" + method.getName());
		return null;
	}

}
