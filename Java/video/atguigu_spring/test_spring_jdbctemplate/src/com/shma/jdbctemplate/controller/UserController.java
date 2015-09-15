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
		user.setAddress("��Ȫ������С��23��Ժ1��Ԫ302��");
		user.setEmail("616059480@qq.com");
		user.setpName("������Ƶ����");
		user.setSex("��");
		user.setTel("13511012671");
		user.setUserName("���ػ�");
		userService.save(user);
	}
	
	public void batchSave() {
		List<User> users = new ArrayList<User>();
		for(int i=0; i<10; ++i) {
			User user = new User();
			user.setAddress("��Ȫ������С��23��Ժ1��Ԫ302��");
			user.setEmail("616059480@qq.com");
			user.setpName("������Ƶ����");
			user.setSex("��");
			user.setTel("13511012671");
			user.setUserName("���ػ�");
			
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
		user.setAddress("�����ߺ�");
		user.setEmail("1039055979@qq.com");
		user.setpName("Ӣ������");
		user.setSex("Ů");
		user.setTel("18301423090");
		user.setUserId(3);
		user.setUserName("�뽿��");
		
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
