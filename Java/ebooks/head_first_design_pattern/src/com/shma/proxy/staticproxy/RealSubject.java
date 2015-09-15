package com.shma.proxy.staticproxy;

public class RealSubject implements ISubject {

	@Override
	public void request() {
		System.out.println("realSubject requesting");
	}

}
