package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.spring.annotation.UserController;
import com.shma.spring.annotation.UserItem;
import com.shma.spring.annotation.dao.IUserDao;
import com.shma.spring.annotation.service.IUserService;

public class AnnotationTest {

	private ApplicationContext ctx;
	
	@Before
	public void before() {
		ctx = new ClassPathXmlApplicationContext("config/bean-annotation.xml");			
	}
	
	@Test
	public void test() {
//		IUserDao userDao = (IUserDao) ctx.getBean("userDao");
//		System.out.println(userDao);
//		
//		IUserService userService = (IUserService) ctx.getBean("userService");
//		System.out.println(userService);
		
		UserController userController = (UserController) ctx.getBean("userController");
		System.out.println(userController);
		
		userController.save();
		
//		UserItem userItem = (UserItem) ctx.getBean("userItem");
//		System.out.println(userItem);
		
	}
	
	
}
