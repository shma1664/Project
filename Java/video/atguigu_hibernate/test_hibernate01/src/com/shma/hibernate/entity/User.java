package com.shma.hibernate.entity;

import java.sql.Date;

public class User {

	private int id;
	private String name;
	private int age;
	private Date date;
	
	public User() {
		super();
	}
	
	public User(String name, int age, Date date) {
		super();
		this.name = name;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", date=" + date + "]";
	}
}
