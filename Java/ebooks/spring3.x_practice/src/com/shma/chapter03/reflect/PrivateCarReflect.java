package com.shma.chapter03.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射调用私有属性和私有方法
 * @author admin
 *
 */
public class PrivateCarReflect {

	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException, NoSuchFieldException, SecurityException, NoSuchMethodException, InvocationTargetException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class<?> clazz = classLoader.loadClass("com.shma.chapter03.reflect.Car");
		
		Car car = (Car) clazz.newInstance();
		
		Field brandField = clazz.getDeclaredField("brand");
		brandField.setAccessible(true);
		brandField.set(car, "BMW");
		
		Field colorField = clazz.getDeclaredField("color");
		colorField.setAccessible(true);
		colorField.set(car, "red");
		
		Field maxSpeedField = clazz.getDeclaredField("maxSpeed");
		maxSpeedField.setAccessible(true);
		maxSpeedField.set(car, 500);
		
		Method method = clazz.getDeclaredMethod("drive", String.class);
		method.setAccessible(true);
		method.invoke(car, "张三");
	}
}
