package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.autowire.Person;

public class AutoWireTest {

	private ApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/autowire.xml");
	}
	
	@Test
	public void test() {
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		
		Person person02 = (Person) ctx.getBean("person02");
		System.out.println(person02);
	}
}
