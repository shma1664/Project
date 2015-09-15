package com.shma.reflection;

import java.lang.reflect.Method;

import org.junit.Test;

public class TestGetterSetterReflection {

	@Test
	public void test() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("com.shma.reflection.Student");
		
		Method[] methods = clazz.getMethods();
		
		for(Method method : methods) {
			if(isGetter(method)) {
				System.out.println("Getter Method : " + method.getName());
			}
			
			if(isSetter(method)) {
				System.out.println("Setter Method : " + method.getName());
			}
		}
	}
	
	private boolean isGetter(Method method) {
		String methodName = method.getName();
		if(!methodName.startsWith("get")) {
			return false;
		}
		
		Class<?>[] paramClasses = method.getParameterTypes();
		
		if(paramClasses == null || paramClasses.length >= 1) {
			return false;
		}
		
		return true;
	}
	
	private boolean isSetter(Method method) {
		String methodName = method.getName();
		if(!methodName.startsWith("set")) {
			return false;
		}
		
		Class<?>[] paramClasses = method.getParameterTypes();
		if(paramClasses == null || paramClasses.length <= 0) {
			return false;
		}
		
		return true;
	}

}
