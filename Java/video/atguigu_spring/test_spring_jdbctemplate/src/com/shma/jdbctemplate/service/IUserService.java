package com.shma.jdbctemplate.service;

import java.util.List;

import com.shma.jdbctemplate.entity.User;

public interface IUserService {

public void save(User user);
	
	public void batchSave(List<User> users);
	
	public void del(User user);
	
	public void modify(User user);
	
	public User query(int id);
	
	public List<User> queryAll();
}
