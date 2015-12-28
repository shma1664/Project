package com.shma.chapter03.applicationcontext;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.chapter03.reflect.Car;

public class ApplicationContextTest {

	@Test
	public void test() {
		ApplicationContext aContext = new ClassPathXmlApplicationContext(new String[]{"classpath:com/shma/chapter03/applicationcontext/beans.xml"});
		System.out.println(aContext.getBean("car", Car.class));
	}
	
	@Test
	public void testAnnotation() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		System.out.println(ctx.getBean("car", Car.class));
	}
}
