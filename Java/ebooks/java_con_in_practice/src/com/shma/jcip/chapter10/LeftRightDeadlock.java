package com.shma.jcip.chapter10;

public class LeftRightDeadlock {

	private final Object leftObject = new Object();
	private final Object rightObject = new Object();
	
	public void leftRight() {
		synchronized (leftObject) {
			synchronized (rightObject) {
				doSomething();
			}
		}
	}
	
	public void righteLeft() {
		synchronized (rightObject) {
			synchronized (leftObject) {
				doSomethingElse();
			}
		}
	}
	
	void doSomething() {
    }

    void doSomethingElse() {
    }
}
