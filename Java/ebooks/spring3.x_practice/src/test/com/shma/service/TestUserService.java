package test.com.shma.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shma.chapter02.login.domain.User;
import com.shma.chapter02.login.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestUserService {

	@Autowired
    private UserService userService; 
	
	@Test
	public void testHasMatchUser() {
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "1111111");
		
		Assert.assertTrue(b1);
		Assert.assertTrue(b2);
	}
	
	@Test
	public void testFindUserByUserName() {
		User user = userService.findUserByUserName("admin");
		System.out.println(user);
		
		user = userService.findUserByUserName("shma");
		System.out.println(user);
	}
	
	@Test
	public void testloginSuccess() {
		
		userService.loginSuccess(1, "2015-12-25 09:47:55", "219.201.29.127", 5);
	}
}
