package com.shma.spring.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shma.spring.annotation.dao.IUserDao;

@Service("userService")
public class UserServiceImpl implements IUserService {

	
	private IUserDao userDao3;
	
	@Autowired
	public void setUserDao3(@Qualifier("userDao") IUserDao userDao3) {
		this.userDao3 = userDao3;
	}



	@Override
	public void save() {
		System.out.println("UserService save...");
		userDao3.save();
	}

}
