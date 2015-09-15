package com.shma.spring.spel;


public class Person {

	private String name;
	
	private Car car;
	
	private String city;
	
	private String levelInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLevelInfo() {
		return levelInfo;
	}

	public void setLevelInfo(String levelInfo) {
		this.levelInfo = levelInfo;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + ", city=" + city + ", levelInfo=" + levelInfo + "]";
	}
}
