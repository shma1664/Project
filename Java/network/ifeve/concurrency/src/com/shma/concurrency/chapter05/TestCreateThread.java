package com.shma.concurrency.chapter05;

/**
 * 创建线程
 * @author admin
 *
 */
public class TestCreateThread {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		
		/**
		 * 线程启动是有序的，但是执行是无序的，执行是由操作系统和JVM决定的，执行顺序与启动顺序并非一致
		 *  main
			Thread1
			Thread0
			Thread2
			Thread3
			Thread4
			Thread6
			Thread5
			Thread7
			Thread8
			Thread9
		 */
		for(int i=0; i<10; ++i) {
			//匿名线程
			new Thread("Thread" + i) {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
				
			}.start();
		}
	}
}
