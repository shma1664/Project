package com.shma.chapter10;

import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class Channel<T> {

	private final int maxNum;
	
	private final T[] caches;
	
	private int tail = 0; //下一个put地方
	
	private int head = 0; //下一个take地方
	
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
			System.out.println(Thread.currentThread().getName() + "生产了：" + data + ", counter:" + counter.incrementAndGet());
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
			System.out.println(Thread.currentThread().getName() + "消费了：" + data + ", counter:" + counter.decrementAndGet());
		}
		return data;
	}
	
	
}
