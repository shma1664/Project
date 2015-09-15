package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.relation.Properties;

public class RelationTest {

	private ApplicationContext ctx;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("config/relation.xml");
	}

	@Test
	public void test() {
		Properties properties = (Properties) ctx.getBean("prop01");
		System.out.println(properties);
		
		Properties properties2 = (Properties) ctx.getBean("prop02");
		System.out.println(properties2);
	}

}
