package com.shma.queue;

import org.junit.Test;

public class MyQueueTest {

	@Test
	public void test() {
		MyQueue queue = new MyQueue(5);
		queue.insert(10);
		queue.insert(20);
		queue.insert(30);
		queue.insert(40);
		queue.insert(50);
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		
		while(!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		
		System.out.println("------------");
		
		queue.insert(10);
		queue.insert(20);
		queue.insert(30);
		queue.insert(40);
		queue.insert(50);
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		
		while(!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
 	}

}
