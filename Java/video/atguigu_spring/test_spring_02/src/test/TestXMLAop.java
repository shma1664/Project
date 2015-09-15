package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.aopxml.Calculator;

/**
 * 
 * @author h p
 *
 */
public class TestXMLAop {

	private ApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/beans-xmlaop.xml");
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
