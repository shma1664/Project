package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.factory.Car;

public class FactoryTest {

	private ApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/beans-factory.xml");
	}
	
	@Test
	public void test() {
		Car car1 = (Car) ctx.getBean("car1");
		
		System.out.println(car1);
		
		Car car2 = (Car) ctx.getBean("car2");
		
		System.out.println(car2);
	}
}
