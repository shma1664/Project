package com.shma.jcip.chapter03;

import com.shma.jcip.annotation.NotThreadSafe;

/**
 * 非线程安全的
 * 三种输出情况：
 * 	1) 正常输出42
 * 	2) 输出0，读线程只看到了ready值，没有看到number值
 * 	3) 死循环，读线程永远看不到ready值
 * 
 *  结论：在没有同步的情况下， 编译器、处理器以及运行时等都有可能对操作的执行顺序进行一些意想不到的调整。
 *  	在缺乏足够同步的多线程程序中，要想对内存操作的执行顺序进行判断，几乎无法得到正确的结论
 *  
 *  如果解决：只要有数据在多个线程中共享，就使用正确的同步
 * @author admin
 *
 */
@NotThreadSafe
public class NoVisibility {

	private static boolean ready;
	private static int number;
	
	private static class ReaderThread extends Thread {

		@Override
		public void run() {
			while(!ready) {
				Thread.yield();
			}
			System.out.println(number);
		}
		
	}
	
	public static void main(String[] args) {
		ReaderThread thread = new ReaderThread();
		thread.start();
		
		number = 42;
		ready = true;
	}
}
