package com.shma.proxy.staticproxy;

public class TestMainApp {

	public static void main(String[] args) {
		ISubject subject = new ProxySubject();
		subject.request();
	}

}
