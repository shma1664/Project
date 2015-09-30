package com.shma.chapter08;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ��д��ʵ��
 * @author admin
 *
 */
public class ReaderWriterLock {

	// ���ڶ�ȡ���̸߳���
	private final AtomicInteger readingCounter = new AtomicInteger(0);
	
	// �ȴ�д���̸߳���
	private final AtomicInteger waitingWriterCounter = new AtomicInteger(0);
	
	// �Ƿ�����д
	private volatile boolean isWritering = false;
	
	// �Ƿ�д����
	private volatile boolean isWritePriority = true;
	
	private final Object object = new Object();
	
	/**
	 * ��ȡ����
	 * @throws InterruptedException 
	 */
	public void readLock() throws InterruptedException {
		//���߳�����д��������̵߳ȴ�д��
		if(isWritering || 
				(isWritePriority && waitingWriterCounter.get() > 0)) {
			synchronized(object) {
				object.wait();
			}
		}
		
		readingCounter.incrementAndGet();
		
	}
	
	/**
	 * �ͷŶ���
	 */
	public void unReadLock() {
		readingCounter.decrementAndGet();
		isWritePriority = true;
		synchronized(object) {
			object.notifyAll();
		}
	}
	
	/**
	 * ��ȡд��
	 * @throws InterruptedException 
	 */
	public void writeLock() throws InterruptedException {
		
		waitingWriterCounter.incrementAndGet();
		
		try {
			if(readingCounter.get() > 0 || isWritering) {
				synchronized(object) {
					object.wait();
				}
			}
			
			isWritering = true;
			
		} finally {
			waitingWriterCounter.decrementAndGet();
		}
	}
	
	public void unWriteLock() {
		isWritering = false;
		isWritePriority = false;
		synchronized(object) {
			object.notifyAll();
		}
	}
}
