package com.shma.jcip.chapter02;

public class Widget {

	public synchronized void doSomething() {
		
	}
}

/**
 * �����Ȼ�ȡ�����ڸ����ڻ�ȡͬһ����
 * @author admin
 *
 */
class LoggingWidget extends Widget {

	@Override
	public synchronized void doSomething() {
		super.doSomething();
	}
	
}
