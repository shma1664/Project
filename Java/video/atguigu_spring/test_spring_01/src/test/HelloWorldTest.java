package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.helloworld.Car;
import com.shma.spring.helloworld.DataSource;
import com.shma.spring.helloworld.HelloWorld;
import com.shma.spring.helloworld.Person;

public class HelloWorldTest {

	private ApplicationContext ctx = null;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
	}

	@Test
	public void test() {
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		helloWorld.sayHello();
		
		
		HelloWorld helloWorld2 = (HelloWorld) ctx.getBean("helloWorld");
		helloWorld2.sayHello();
		
		// 默认单例
		/**
		 * Hello World Constructor...
		   setUserName : 马韶华
		   Hello, 马韶华
		   Hello, 马韶华
		 * 
		 */
		
		// scope="prototype"
		/**
		 * Hello World Constructor...
		   setUserName : 马韶华
		   Hello, 马韶华
		   Hello World Constructor...
		   setUserName : 马韶华
		   Hello, 马韶华
		 * 
		 */
		
		Car car1 = (Car) ctx.getBean("car1");
		
		Car car2 = (Car) ctx.getBean("car2");
		
		System.out.println(car1);
		System.out.println(car2);
		
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		
		Person person2 = (Person) ctx.getBean("person2");
		System.out.println(person2);
		
		Person person3 = (Person) ctx.getBean("person3");
		System.out.println(person3);
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
		
		Person person4 = (Person) ctx.getBean("person4");
		System.out.println(person4);
		
		Person person5 = (Person) ctx.getBean("person5");
		System.out.println(person5);
	}

}
