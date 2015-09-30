package com.shma.chapter08;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 读写锁实现
 * @author admin
 *
 */
public class ReaderWriterLock {

	// 正在读取的线程个数
	private final AtomicInteger readingCounter = new AtomicInteger(0);
	
	// 等待写的线程个数
	private final AtomicInteger waitingWriterCounter = new AtomicInteger(0);
	
	// 是否正在写
	private volatile boolean isWritering = false;
	
	// 是否写优先
	private volatile boolean isWritePriority = true;
	
	private final Object object = new Object();
	
	/**
	 * 获取读锁
	 * @throws InterruptedException 
	 */
	public void readLock() throws InterruptedException {
		//有线程正在写入或者有线程等待写入
		if(isWritering || 
				(isWritePriority && waitingWriterCounter.get() > 0)) {
			synchronized(object) {
				object.wait();
			}
		}
		
		readingCounter.incrementAndGet();
		
	}
	
	/**
	 * 释放读锁
	 */
	public void unReadLock() {
		readingCounter.decrementAndGet();
		isWritePriority = true;
		synchronized(object) {
			object.notifyAll();
		}
	}
	
	/**
	 * 获取写锁
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
