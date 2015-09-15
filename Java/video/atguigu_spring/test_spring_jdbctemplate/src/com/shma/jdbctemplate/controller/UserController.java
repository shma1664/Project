package com.shma.jdbctemplate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shma.jdbctemplate.entity.User;
import com.shma.jdbctemplate.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	
	public void save() {
		User user = new User();
		user.setAddress("万泉寺南里小区23号院1单元302室");
		user.setEmail("616059480@qq.com");
		user.setpName("呱呱视频社区");
		user.setSex("男");
		user.setTel("13511012671");
		user.setUserName("马韶华");
		userService.save(user);
	}
	
	public void batchSave() {
		List<User> users = new ArrayList<User>();
		for(int i=0; i<10; ++i) {
			User user = new User();
			user.setAddress("万泉寺南里小区23号院1单元302室");
			user.setEmail("616059480@qq.com");
			user.setpName("呱呱视频社区");
			user.setSex("男");
			user.setTel("13511012671");
			user.setUserName("马韶华");
			
			users.add(user);
		}
		
		userService.batchSave(users);
	}
	
	public void del(int id) {
		User user = new User();
		user.setUserId(id);
		userService.del(user);
	}
	
	public void modify() {
		User user = new User();
		user.setAddress("安徽芜湖");
		user.setEmail("1039055979@qq.com");
		user.setpName("英特普罗");
		user.setSex("女");
		user.setTel("18301423090");
		user.setUserId(3);
		user.setUserName("齐娇娇");
		
		userService.modify(user);
	}
	
	public void query(int id) {
		User user = userService.query(id);
		System.out.println(user);
	}
	
	public void query() {
		List<User> users = userService.queryAll();
		System.out.println(users);
	}
}
