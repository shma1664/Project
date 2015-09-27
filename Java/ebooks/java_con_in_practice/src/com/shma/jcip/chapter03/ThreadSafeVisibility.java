package com.shma.jcip.chapter03;

import com.shma.jcip.annotation.ThreadSafe;

/**
 * 
 *  在没有同步的情况下， 编译器、处理器以及运行时等都有可能对操作的执行顺序进行一些意想不到的调整。
 *  	在缺乏足够同步的多线程程序中，要想对内存操作的执行顺序进行判断，几乎无法得到正确的结论
 *  
 *  如果解决：只要有数据在多个线程中共享，就使用正确的同步
 * @author admin
 *
 */
@ThreadSafe
public class ThreadSafeVisibility {

	private static boolean ready;
	private static int number;
	
	public static void setValue(boolean pReady, int pNumber) {
		synchronized (ThreadSafeVisibility.class) {
			ready = pReady;
			number = pNumber;
		}
	}
	
	public static boolean getReady() {
		synchronized (ThreadSafeVisibility.class) {
			return ready;
		}
	}
	
	public static int getNumber() {
		synchronized (ThreadSafeVisibility.class) {
			return number;
		}
	}
	
	private static class ReaderThread extends Thread {

		@Override
		public void run() {
			while(!getReady()) {
				Thread.yield();
			}
			System.out.println(getNumber());
		}
		
	}
	
	public static void main(String[] args) {
		ReaderThread thread = new ReaderThread();
		thread.start();
		
		setValue(true, 42);
	}
}
