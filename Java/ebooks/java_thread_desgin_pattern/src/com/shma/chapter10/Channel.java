package com.shma.chapter10;

import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class Channel<T> {

	private final int maxNum;
	
	private final T[] caches;
	
	private int tail = 0; //��һ��put�ط�
	
	private int head = 0; //��һ��take�ط�
	
	private final AtomicInteger counter;
	
	public Channel(Class<?> clazz, int size) {
		this.maxNum = size;
		caches = (T[]) Array.newInstance(clazz, maxNum);
		counter = new AtomicInteger(0);
	}
	
	public void put(T data) throws InterruptedException {
		
		synchronized(this) {
			while(counter.get() >= maxNum) {
				wait();
			}
			
			caches[tail] = data;
			tail = (tail + 1) % maxNum;
			notifyAll();
			System.out.println(Thread.currentThread().getName() + "�����ˣ�" + data + ", counter:" + counter.incrementAndGet());
		}
	}
	
	public T take() throws InterruptedException {
		
		T data = null;
		
		synchronized(this) {
			while(counter.get() <= 0) {
				wait();
			}
			
			data = caches[head];
			head = (head + 1) % maxNum;
			notifyAll();
			System.out.println(Thread.currentThread().getName() + "�����ˣ�" + data + ", counter:" + counter.decrementAndGet());
		}
		return data;
	}
	
	
}
