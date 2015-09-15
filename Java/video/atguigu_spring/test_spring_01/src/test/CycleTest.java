package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.cycle.Car;

public class CycleTest {

	private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/beans-cycle.xml");
	}
	
	@Test
	public void test() {
		Car car = (Car) ctx.getBean("car");
//		Computer computer = (Computer) ctx.getBean("computer");
		
		System.out.println(car);
		
//		System.out.println(computer);
		
		ctx.close();
	}
}
