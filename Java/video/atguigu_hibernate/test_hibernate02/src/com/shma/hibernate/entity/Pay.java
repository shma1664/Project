package com.shma.hibernate.entity;

public class Pay {

	private double monthPay;
	private double yearPay;
	private int yearDay;
	
	private Worker worker;
	
	public double getMonthPay() {
		return monthPay;
	}
	public void setMonthPay(double monthPay) {
		this.monthPay = monthPay;
	}
	public double getYearPay() {
		return yearPay;
	}
	public void setYearPay(double yearPay) {
		this.yearPay = yearPay;
	}
	public int getYearDay() {
		return yearDay;
	}
	public void setYearDay(int yearDay) {
		this.yearDay = yearDay;
	}
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
	
}
