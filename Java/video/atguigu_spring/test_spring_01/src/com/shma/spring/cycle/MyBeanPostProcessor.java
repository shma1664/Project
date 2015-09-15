package com.shma.spring.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * ∫Û÷√¥¶¿Ì∆˜
 * @author h p
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("postProcessAfterInitialization, bean : "
							+ bean + ", beanName : " + beanName);
		
		if(bean instanceof Car) {
			Car car = new Car();
			car.setBrand("baoma");
			car.setCorp("X3");
			car.setPrice(500000);
			
			bean = car;
		}
		
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization, bean : "
							+ bean + ", beanName : " + beanName);
		
		return bean;
	}

}
