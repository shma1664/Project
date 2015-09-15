package com.shma.proxy.dynamicproxy;

public class TestMainApp {

	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		ISubject subject = (ISubject)SubjectInvocationHandler.getProxyInstanceFactory(realSubject);
       
		subject.request();
	}

}
