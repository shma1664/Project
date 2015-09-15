package com.shma.concurrency.chapter11;

public class MyWaitNotify {

	private Object obj = new Object();
	
	/**
	 * 等待线程，调用该方法的线程将释放锁，处于等待状态，直到别的线程调用obj的doNotify()或doNotifyAll()方法，才有可能会重新获得锁
	 * 跳出wait()方法，继续执行
	 */
	public void doWait() {
		synchronized(obj) {
			try {
				obj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 唤醒线程，调用该方法的，有一个被等待的线程将获取锁的机会，继续执行
	 */
	public void doNotify() {
		synchronized(obj) {
			obj.notify();
		}
	}
	
	/**
	 * 唤醒线程，调用该方法的，所有被等待的线程将获取锁的机会，继续执行
	 */
	public void doNotifyAll() {
		synchronized(obj) {
			obj.notifyAll();
		}
	}
}
