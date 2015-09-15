package com.shma.spring.spel;

public class Car {

	private String brand;
	
	private String corp;
	
	private double price;
	
	private int speed;
	
	private float rand;

	public Car() {
		super();
		System.out.println("Const init...");
	}

	public Car(String brand, String corp, double price) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}

	public Car(String brand, String corp, int speed) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.speed = speed;
	}

	public Car(String brand, String corp, double price, int speed, float rand) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
		this.speed = speed;
		this.rand = rand;
	}

	public float getRand() {
		return rand;
	}

	public void setRand(float rand) {
		this.rand = rand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", corp=" + corp + ", price=" + price + ", speed=" + speed + ", rand=" + rand
				+ "]";
	}
	
}
