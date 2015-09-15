package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.jdbctemplate.controller.UserController;

public class JdbcTemplateTest {

	private ApplicationContext ctx;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
	}

	@Test
	public void test() {
		UserController userController = (UserController) ctx.getBean("userController");
		 userController.save();

		// userController.batchSave();

		// userController.del(4);

		// userController.modify();

		// userController.query(3);

		// userController.query();

	}
}
