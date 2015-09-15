package com.shma.proxy.staticproxy;

/**
 * ¥˙¿Ì¿‡
 * @author h p
 *
 */
public class ProxySubject implements ISubject {

	private ISubject subject;
	
	public ProxySubject() {
		subject = new RealSubject();
	}
	
	@Override
	public void request() {
		System.out.println("do something before");
		subject.request();
        System.out.println("do something after");
	}

}
