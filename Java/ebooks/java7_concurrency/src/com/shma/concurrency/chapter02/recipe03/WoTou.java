package com.shma.concurrency.chapter02.recipe03;

public class WoTou {

	private int id;
	
	private String name;

	public WoTou() {
		super();
	}

	public WoTou(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "WoTou [id=" + id + ", name=" + name + "]";
	}

}
