package com.shma.stack;

import org.junit.Test;

public class MyStackTest {

	@Test
	public void test() {
		MyStack ms = new MyStack(5);
		ms.push(10);
		ms.push(20);
		ms.push(30);
		ms.push(40);
		ms.push(50);
//		ms.push(60);
		
		System.out.println(ms.peek());
		System.out.println(ms.peek());
		
		try {
			while(true) {
				System.out.println(ms.pop());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ms.push(10);
		ms.push(20);
		ms.push(30);
		ms.push(40);
		ms.push(50);
		
		System.out.println(ms.peek());
		System.out.println(ms.peek());
		
		while(!ms.isEmpty()) {
			System.out.println(ms.pop());
		}
	}

}
