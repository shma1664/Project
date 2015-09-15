package com.shma.spring.generic.di.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.shma.spring.generic.di.dao.IBaseDao;

public class BaseService<T> implements IBaseService<T> {

	@Autowired
	private IBaseDao<T> baseDao;
	
	@Override
	public void save(T t) {
		System.out.println("service add...");
		baseDao.add(t);
	}

}
