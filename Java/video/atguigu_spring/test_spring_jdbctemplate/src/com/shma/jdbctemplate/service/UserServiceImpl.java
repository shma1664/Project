package com.shma.jdbctemplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shma.jdbctemplate.dao.IUserDao;
import com.shma.jdbctemplate.entity.User;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void batchSave(List<User> users) {
		userDao.batchSave(users);
	}

	@Override
	public void del(User user) {
		userDao.del(user);
	}

	@Override
	public void modify(User user) {
		userDao.modify(user);
	}

	@Override
	public User query(int id) {
		return userDao.query(id);
	}

	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

}
