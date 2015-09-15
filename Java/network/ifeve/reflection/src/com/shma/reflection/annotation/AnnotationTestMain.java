package com.shma.reflection.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTestMain {

	public static void main(String[] args) {
		
		try {
			testClassAnnotation();
			testMethodAnnotation();
			testMethodParamAnnotation();
			testFieldAnnotation();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testFieldAnnotation() throws SecurityException, NoSuchFieldException {
		Field field = TheClass.class.getField("myField");
		
		MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
		System.out.println(annotation.name());
		System.out.println(annotation.value());
	}
	
	public static void testClassAnnotation() {
		Annotation[] annotations = TheClass.class.getAnnotations();
		for(Annotation annotation : annotations) {
			if(annotation instanceof MyAnnotation) {
				MyAnnotation myAnnotation = (MyAnnotation) annotation;
				System.out.println(myAnnotation.name());
				System.out.println(myAnnotation.value());
			}
		}
		
		
		MyAnnotation annotation = TheClass.class.getAnnotation(MyAnnotation.class);
		System.out.println(annotation.name());
		System.out.println(annotation.value());
	}
	
	public static void testMethodAnnotation() throws SecurityException, NoSuchMethodException {

		Method method = TheClass.class.getMethod("doSomething", null);
		MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
		System.out.println(annotation.name());
		System.out.println(annotation.value());
	}
	
	public static void testMethodParamAnnotation() throws SecurityException, NoSuchMethodException {
		Method method = TheClass.class.getMethod("init", String.class);
		Annotation[][] annotations = method.getParameterAnnotations();
		
		for(Annotation[] annotations2 : annotations) {
			for(Annotation annotation : annotations2) {
				if(annotation instanceof MyAnnotation) {
					MyAnnotation ann = (MyAnnotation) annotation;
					System.out.println(ann.name());
					System.out.println(ann.value());
				}
			}
		}
	}
}
