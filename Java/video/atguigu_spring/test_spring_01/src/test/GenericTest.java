package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.generic.di.entity.User;
import com.shma.spring.generic.di.service.UserService;

public class GenericTest {
private ApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/bean-generic.xml");
	}
	
	@Test
	public void test() {
		UserService userService = (UserService) ctx.getBean("userService");
		User user = new User();
		user.setPassword("123456");
		user.setUsername("admin");
		userService.save(user);
	}
}
