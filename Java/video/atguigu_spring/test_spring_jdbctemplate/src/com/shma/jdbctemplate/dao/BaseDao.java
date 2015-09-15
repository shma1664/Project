package com.shma.jdbctemplate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao<T> implements IBaseDao<T> {

	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	@Override
	public void save(T t) {
	}

	@Override
	public void del(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T query(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
