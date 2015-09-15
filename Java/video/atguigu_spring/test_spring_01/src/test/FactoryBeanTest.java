package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.factorybean.Car;

public class FactoryBeanTest {

	private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/bean-factorybean.xml");
	}
	
	@Test
	public void test() {
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
	}
}
