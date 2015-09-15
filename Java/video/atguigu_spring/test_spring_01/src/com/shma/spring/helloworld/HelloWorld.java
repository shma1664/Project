package com.shma.spring.helloworld;

public class HelloWorld {

	private String userName;
	
	public HelloWorld() {
		System.out.println("Hello World Constructor...");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("setUserName : " + userName);
		this.userName = userName;
	}
	
	public void sayHello() {
		System.out.println("Hello, " + userName);
	} 
}
