package com.shma.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class TestFieldReflection {

	@Test
	public void test() {
		try {
			Class<?> clazz = Class.forName("com.shma.reflection.Student");
			//所有公共的属性字段
			Field[] fields = clazz.getFields();
			for(Field field : fields) {
				System.out.println(field.getName());
				System.out.println(field.getType().getName());
			}
			
			Constructor<?> constructor = clazz.getConstructor(new Class[]{});
			Student student = (Student) constructor.newInstance();
			
			Field field = clazz.getField("myNameString");
			field.set(student, "我是中国人");
			System.out.println(field.get(student));
			
			Field field2 = clazz.getField("currState");
			field2.set(null, 1);
			System.out.println(field2.get(null));
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
