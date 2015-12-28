package com.shma.chapter03.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射机制创建对象
 * @author admin
 *
 */
public class ReflectTest {

	public static Car initByConst() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("com.shma.chapter03.reflect.Car");
		Constructor<?> constructor = clazz.getConstructor((Class[])null);
		Car car = (Car)constructor.newInstance();
		
		Method setBrandMethod = clazz.getMethod("setBrand", String.class);
		setBrandMethod.invoke(car, "奥迪A4");
		
		Method setColorMethod = clazz.getMethod("setColor", String.class);
		setColorMethod.invoke(car, "white");
		
		Method setMaxSpeedMethod = clazz.getMethod("setMaxSpeed", int.class);
		setMaxSpeedMethod.invoke(car, 200);
		
		return car;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(ReflectTest.initByConst());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
