package com.shma.chapter07;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者模式中的存储中介
 * @author admin
 *
 */
public class Table {

	private final String[] buffer;
	private int tail; //下一个put地址
	private int head; //下一个take位置
	private final AtomicInteger counter;
	
	private final Random random = new Random();
	
	public Table(int count) {
		this.buffer = new String[count];
		counter = new AtomicInteger();
		tail = 0;
		head = 0;
	}
	
	public void put(String cake) throws InterruptedException {

		synchronized (this) {
			if(counter.get() > buffer.length) {
				wait();
			}
			buffer[tail] = cake;
			tail = (tail + 1) % buffer.length;
		}
		
		counter.incrementAndGet();
		
		synchronized(this) {
			notifyAll();
		}
		
		System.out.println(Thread.currentThread().getName() + " puts " + cake + ", counter:" + counter.incrementAndGet());
		
	}
	
	public String take() throws InterruptedException {
		String cake = null;
		synchronized (this) {
			if(counter.get() <= 0) {
				wait();
			}
			
			cake = buffer[head];
			head = (head + 1) % buffer.length;
			
			notifyAll();
		}
		
		System.out.println(Thread.currentThread().getName() + " takes " + cake + ", counter:" + counter.decrementAndGet());
		
		return cake;
	}
	
}
