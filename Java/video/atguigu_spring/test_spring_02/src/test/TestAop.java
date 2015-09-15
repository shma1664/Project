package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.aop.Calculator;

/**
 * 
 * @author h p
 *
 */
public class TestAop {

	private ApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/beans-aop.xml");
	}
	
	@Test
	public void test() {
		Calculator<Integer> calculator = (Calculator<Integer>) ctx.getBean("calculator");
		System.out.println(calculator.add(1, 2));
		System.out.println(calculator.sub(10, 2));
		System.out.println(calculator.mult(10, 2));
		System.out.println(calculator.div(10, 0));
	}

}
