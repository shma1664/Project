package com.shma.jcip.chapter02;

public class Widget {

	public synchronized void doSomething() {
		
	}
}

/**
 * 子类先获取锁，在父类在获取同一个锁
 * @author admin
 *
 */
class LoggingWidget extends Widget {

	@Override
	public synchronized void doSomething() {
		super.doSomething();
	}
	
}
