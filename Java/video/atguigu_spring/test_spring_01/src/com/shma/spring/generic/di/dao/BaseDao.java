package com.shma.spring.generic.di.dao;

public class BaseDao<T> implements IBaseDao<T> {

	@Override
	public void add(T t) {
		System.out.println("dao add...£º" + t);
	}

}
