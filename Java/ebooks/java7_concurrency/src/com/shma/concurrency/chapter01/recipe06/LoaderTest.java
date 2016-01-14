package com.shma.concurrency.chapter01.recipe06;

import org.junit.Test;

public class LoaderTest {

	@Test
	public void test() {
		Thread thread = new Thread(new DataSourceLoader(), "dataSource");
		Thread thread2 = new Thread(new NetworkConnectionsLoader(), "networkConn");
		
		thread.start();
		thread2.start();
		
		try {
			thread.join();
			thread2.join(); //join，main方法线程等待thread和thread2线程结束后才能继续执行后续方法
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("资源加载结束");
		
		
	}
}
