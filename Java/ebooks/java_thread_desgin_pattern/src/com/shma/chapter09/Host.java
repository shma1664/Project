package com.shma.chapter09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个任务一个线程模式
 * @author admin
 *
 */
public class Host {

	private final Helper helper = new Helper();
	
	private final ExecutorService executorService = Executors.newCachedThreadPool();
	
	public void request(final int count, final char c) {
		System.out.println("request (" + count + ", " + c + ") begin");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				helper.handle(count, c);
			}
		}).start();
		
		System.out.println("request (" + count + ", " + c + ") end");
	}
}
