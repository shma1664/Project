package com.shma.concurrency.chapter11;

public class MyWaitNotify {

	private Object obj = new Object();
	
	/**
	 * �ȴ��̣߳����ø÷������߳̽��ͷ��������ڵȴ�״̬��ֱ������̵߳���obj��doNotify()��doNotifyAll()���������п��ܻ����»����
	 * ����wait()����������ִ��
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
	 * �����̣߳����ø÷����ģ���һ�����ȴ����߳̽���ȡ���Ļ��ᣬ����ִ��
	 */
	public void doNotify() {
		synchronized(obj) {
			obj.notify();
		}
	}
	
	/**
	 * �����̣߳����ø÷����ģ����б��ȴ����߳̽���ȡ���Ļ��ᣬ����ִ��
	 */
	public void doNotifyAll() {
		synchronized(obj) {
			obj.notifyAll();
		}
	}
}
