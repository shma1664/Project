package com.shma.chapter05;

public class Request {

	private final String name;
	
	public Request(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Request [name=" + name + "]";
	}

}
