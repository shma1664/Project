package com.shma.spring.cycle;

/**
 * 1)构造器
 * 2)setter方法
 * 3)postProcessAfterInitialization
 * 4)init
 * 5)postProcessBeforeInitialization
 * 6)destory 
 * @author h p
 *
 */
public class Car {

	private String brand;
	
	private String corp;
	
	private double price;
	
	private int speed;

	public Car() {
		super();
		System.out.println("constructor init...");
	}

	public Car(String brand, String corp, double price, int speed) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
		this.speed = speed;
	}
	
	public void init() {
		System.out.println("init...");
	}
	
	public void destroy() {
		System.out.println("destroy...");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("attribute init...");
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
		return "Car [brand=" + brand + ", corp=" + corp + ", price=" + price + ", speed=" + speed + "]";
	}
}
