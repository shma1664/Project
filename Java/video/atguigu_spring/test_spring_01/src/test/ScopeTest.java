package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.autowire.Car;

public class ScopeTest {

	private ApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/scope.xml");
	}
	
	@Test
	public void test() {
		Car car01 = (Car) ctx.getBean("car");
		Car car02 = (Car) ctx.getBean("car");
		
		System.out.println(car01 == car02);
		
		Car car03 = (Car) ctx.getBean("car1");
		Car car04 = (Car) ctx.getBean("car1");
		
		System.out.println(car04 == car03);
		
	}
}
