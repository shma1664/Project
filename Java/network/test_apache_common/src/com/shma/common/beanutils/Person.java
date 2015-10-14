package com.shma.common.beanutils;

import java.util.Date;

public class Person {

	private int id;
	
	private String name;
	
	private Date date;

	public Person() {
		super();
	}

	public Person(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

}
