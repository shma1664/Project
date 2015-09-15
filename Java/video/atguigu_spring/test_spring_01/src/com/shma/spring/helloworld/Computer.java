package com.shma.spring.helloworld;

public class Computer {
	
	private String cpu;
	
	private float memory;
	
	private double hardDisk;

	public Computer() {
		super();
	}

	public Computer(String cpu, float memory, double hardDisk) {
		super();
		this.cpu = cpu;
		this.memory = memory;
		this.hardDisk = hardDisk;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public float getMemory() {
		return memory;
	}

	public void setMemory(float memory) {
		this.memory = memory;
	}

	public double getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(double hardDisk) {
		this.hardDisk = hardDisk;
	}

	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", memory=" + memory + ", hardDisk=" + hardDisk + "]";
	}
	
}
