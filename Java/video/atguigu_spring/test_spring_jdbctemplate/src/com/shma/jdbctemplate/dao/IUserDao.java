package com.shma.jdbctemplate.dao;

import java.util.List;

import com.shma.jdbctemplate.entity.User;

public interface IUserDao {

	public void save(User user);
	
	public void batchSave(List<User> users);
	
	public void del(User user);
	
	public void modify(User user);
	
	public User query(int id);
	
	public List<User> queryAll();
}
