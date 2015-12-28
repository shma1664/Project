package com.shma.chapter03.ioc;

public abstract class Geli {

	private String name;

	public Geli() {
		super();
	}

	public Geli(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void responseAsk(String ask) {
		System.out.println(ask + "，扮演着：" + name);
	}
	
	
}
