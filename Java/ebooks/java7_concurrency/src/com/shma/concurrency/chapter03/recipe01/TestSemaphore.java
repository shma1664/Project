package com.shma.concurrency.chapter03.recipe01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphore {

	public static void main(String[] args) {
		
		//�����̸߳���
		final ExecutorService ex = Executors.newFixedThreadPool(10);
		
		//�ź��������Ʋ�������
		final Semaphore semaphore = new Semaphore(3);
		
		for(int index=0; index<20; ++index) {
			final int no = index;
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					//������ȡ���
					try {
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName() + ", Accept no : " + no);
						TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						semaphore.release();
						System.out.println("-----------------" + Thread.currentThread().getName() + ", no:" + semaphore.availablePermits());
					}
				}
			};
			
			ex.execute(runnable);
		}
		
		ex.shutdown();
	}
}
