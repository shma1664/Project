package com.shma.spring.annotation.dao;

import org.springframework.stereotype.Repository;

@Repository("userDao2")
public class UserDaoImpl2 implements IUserDao {

	@Override
	public void save() {
		System.out.println("UserDaoImpl2 save...");
	}

}
