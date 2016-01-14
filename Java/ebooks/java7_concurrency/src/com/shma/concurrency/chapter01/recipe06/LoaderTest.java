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
			thread2.join(); //join��main�����̵߳ȴ�thread��thread2�߳̽�������ܼ���ִ�к�������
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("��Դ���ؽ���");
		
		
	}
}
