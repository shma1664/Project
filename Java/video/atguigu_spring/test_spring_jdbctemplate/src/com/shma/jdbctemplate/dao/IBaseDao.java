package com.shma.jdbctemplate.dao;

import java.util.List;

public interface IBaseDao<T> {

	public void save(T t);
	
	public void del(T t);
	
	public void modify(T t);
	
	public T query(int id);
	
	public List<T> queryAll();
}
