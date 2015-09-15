package com.shma.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ¶¯Ì¬´úÀí
 * 
 * @author h p
 *
 */
public class DynamicProxy implements InvocationHandler {

	private Object object;

	public Object obj(Object object) {
		this.object = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("The Method : " + method.getName() + " start, params : " + args);
		method.invoke(object, args);
		System.out.println("The Method : " + method.getName() + " end, params : " + args);
		return null;
	}
}
