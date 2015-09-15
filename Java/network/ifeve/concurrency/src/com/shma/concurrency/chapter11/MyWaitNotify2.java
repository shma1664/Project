package com.shma.concurrency.chapter11;

public class MyWaitNotify2 {

	private Object obj = new Object();
	
	/**
	 * �����ź��Ƿ�notify
	 */
	private boolean wasSignalled = false;
	
	/**
	 * �ȴ��̣߳����ø÷������߳̽��ͷ��������ڵȴ�״̬��ֱ������̵߳���obj��doNotify()��doNotifyAll()���������п��ܻ����»����
	 * ����wait()����������ִ��
	 */
	public void doWait() {
		synchronized(obj) {
			//���������notify�����ڵȴ�����ִ�У�����ȴ�����
			if(!wasSignalled) {
				try {
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//��ɺ�״̬��λ��ÿ��ֻ��һ���̻߳ᱻ���Ѵ���
			wasSignalled = false;
			
		}
	}
	
	/**
	 * �����̣߳����ø÷����ģ���һ�����ȴ����߳̽���ȡ���Ļ��ᣬ����ִ��
	 */
	public void doNotify() {
		synchronized(obj) {
			wasSignalled = true;
			obj.notify();
		}
	}
	
	/**
	 * �����̣߳����ø÷����ģ����б��ȴ����߳̽���ȡ���Ļ��ᣬ����ִ��
	 */
	public void doNotifyAll() {
		synchronized(obj) {
			wasSignalled = true;
			obj.notifyAll();
		}
	}
}
