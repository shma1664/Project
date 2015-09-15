package com.shma.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateObjectTestMain {

	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
		
		Class<?> clazz = Class.forName("com.shma.reflection.PrivateObject");
		
		Constructor<?> constructor = clazz.getConstructor(String.class);
		
		PrivateObject privateObject = (PrivateObject) constructor.newInstance("我是中国人");
		
		Field field = clazz.getDeclaredField("privateString");
		
		field.setAccessible(true);
		
		String privateString = (String) field.get(privateObject);
		
		System.out.println(privateString);
		
		Method method = clazz.getDeclaredMethod("setPrivateString", String.class);
		method.setAccessible(true);
		
		method.invoke(privateObject, "我深爱着我的祖国");
		
		Method method2 = clazz.getDeclaredMethod("getPrivateString", null);
		method2.setAccessible(true);
		
		privateString = (String) method2.invoke(privateObject, null);
		
		System.out.println(privateString);
	}
}
