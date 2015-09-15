package test;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.tx.controller.BookController;

public class TransactionManagerTest {

	private ApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("config/applicationContext-xml.xml");
	}
	
	@Test
	public void test() {
		BookController bookController = (BookController)ctx.getBean("bookController");
		
		bookController.buyBook(45243043, 1001);
		
		
//		bookController.checkOut(45243043, Arrays.asList(1001, 1002));
	}

}
