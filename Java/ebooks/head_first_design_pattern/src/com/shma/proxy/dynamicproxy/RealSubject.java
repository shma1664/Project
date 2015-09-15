package com.shma.proxy.dynamicproxy;

public class RealSubject implements ISubject {

	@Override
	public void request() {
		System.out.println("realSubject requesting");
	}

}
