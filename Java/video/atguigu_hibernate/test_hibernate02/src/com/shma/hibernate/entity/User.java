package com.shma.hibernate.entity;

import java.sql.Blob;
import java.util.Date;

public class User {

	private Integer id;
	private String name;
	private Integer age;
	private Date date;
	
	private String oldContent;
	private Blob image;
	
	private String desc;
	
	public User() {
		super();
	}
	
	public User(String name, Integer age, Date date) {
		super();
		this.name = name;
		this.age = age;
		this.date = date;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getOldContent() {
		return oldContent;
	}

	public void setOldContent(String oldContent) {
		this.oldContent = oldContent;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
}
