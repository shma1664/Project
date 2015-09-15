package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.spel.Address;
import com.shma.spring.spel.Car;
import com.shma.spring.spel.Person;

public class SpELTest {

	private ApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/beans-spel.xml");
	}
	
	@Test
	public void test() {
		Address address = (Address) ctx.getBean("address");
		System.out.println(address);
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		Person person = (Person) ctx.getBean("person");
		
		System.out.println(person);
	}
}
