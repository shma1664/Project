package com.shma.chapter03.reflect;

public class Car {

	private String brand;
	private String color;
	private int maxSpeed;

	public Car() {
		super();
	}

	public Car(String brand, String color, int maxSpeed) {
		super();
		this.brand = brand;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", maxSpeed="
				+ maxSpeed + "]";
	}
	
	private void drive(String name) {
		System.err.println(name);
		System.out.println("Car [brand=" + brand + ", color=" + color + ", maxSpeed="
				+ maxSpeed + "]");
	}

}