package com.shma.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestMethodReflection {

	@Test
	public void test() throws Exception {
		
		Class<?> clazz = Class.forName("com.shma.reflection.Student");
		
		Method[] methods = clazz.getMethods();
		
		for(Method method : methods) {
			System.out.println(method.getName());
			
			Class<?>[] paramClasses = method.getParameterTypes();
			for(Class<?> paramClass : paramClasses) {
				System.out.println(method.getName() + " : " + paramClass.getName());
			}
			
			System.out.println(method.getName() + " returnType : " + method.getReturnType().getName());
		}
		
		Constructor<?> constructor = clazz.getConstructor();
		
		Student student = (Student) constructor.newInstance();
		
		Method method = clazz.getMethod("setClassesName", new Class[]{String.class});
		method.invoke(student, "ÈýÄê¶þ°à");
		
		Method stateMethod = clazz.getMethod("print", new Class[]{int.class});
		stateMethod.invoke(null, 999);
		
		System.out.println(student.getClassesName());
		
	}

}
