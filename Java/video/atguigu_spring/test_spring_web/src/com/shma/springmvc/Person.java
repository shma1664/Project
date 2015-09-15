package com.shma.springmvc;

public class Person {

	private String userName;
	
	public void hello() {
		System.out.println("Hello, " + userName);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
