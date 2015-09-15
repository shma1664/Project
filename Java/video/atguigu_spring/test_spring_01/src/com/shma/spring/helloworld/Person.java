package com.shma.spring.helloworld;

import java.util.List;
import java.util.Map;

public class Person {

	private String name;
	private int age;
	private Car car;
	
	private List<Computer> computers;
	
	private Map<String, Computer> computerMap;
	
	public Person() {
		super();
	}

	public Person(String name, int age, Car car) {
		super();
		this.name = name;
		this.age = age;
		this.car = car;
	}

	public Person(String name, int age, Car car, List<Computer> computers) {
		super();
		this.name = name;
		this.age = age;
		this.car = car;
		this.computers = computers;
	}

	public Person(String name, int age, Car car, List<Computer> computers, Map<String, Computer> computerMap) {
		super();
		this.name = name;
		this.age = age;
		this.car = car;
		this.computers = computers;
		this.computerMap = computerMap;
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
	
	public Car getCar() {
		return car;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}

	public List<Computer> getComputers() {
		return computers;
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}

	public Map<String, Computer> getComputerMap() {
		return computerMap;
	}

	public void setComputerMap(Map<String, Computer> computerMap) {
		this.computerMap = computerMap;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", car=" + car + ", computers=" + computers + ", computerMap="
				+ computerMap + "]";
	}
}
