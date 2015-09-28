package com.shma.chapter05;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

public class RequestQueue {

	private LinkedList<Request> queue = new LinkedList<Request>();
	
	private final AtomicLong counter = new AtomicLong();
	
	private final Object object = new Object();
	
	public void put(Request request) {
		System.out.println("添加一个剩余+：" + counter.incrementAndGet());
		counter.incrementAndGet();
		synchronized(object) {
			queue.add(request);
			object.notifyAll();
		}
	}
	
	public Request get() throws InterruptedException {
		Request request = null;
		synchronized(object) {
			while(queue.size() <= 0) {
				object.wait();
			}
			
			request = queue.removeFirst();
		}
		
		System.out.println("拿出一个剩余-：" + counter.decrementAndGet());
		
		return request;
	}
}
