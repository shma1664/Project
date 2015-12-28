package com.shma.chapter03.beanfactory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.shma.chapter03.reflect.Car;

public class BeanFactoryTest {

	@Test
	public void test() {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("classpath:com/shma/chapter03/beanfactory/beans.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		System.out.println("beanFactory init...");
		
		Car car = beanFactory.getBean("car", Car.class);
		System.out.println(car);
		System.out.println("car bean is ready use");
		
		Car car2 = beanFactory.getBean("car", Car.class);
		System.out.println(car == car2);
	}
}
