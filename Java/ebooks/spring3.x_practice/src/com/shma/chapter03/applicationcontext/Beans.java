package com.shma.chapter03.applicationcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shma.chapter03.reflect.Car;

/**
 * 注解的方式
 * @author admin
 *
 */
@Configuration
public class Beans {

	@Bean(name="car")
	public Car buildCar() {
		Car car = new Car();
		car.setBrand("奇瑞QQ");
		car.setColor("蓝色");
		car.setMaxSpeed(300);
		return car;
	}
}
