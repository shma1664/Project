package com.shma.concurrency.chapter06.recipe01;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestMain {

	public static void main(String[] args) throws InterruptedException {
		
		//·Ç×èÈûË«¶Ë¶ÓÁÐ
		ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<String>();
		
		ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		for(int i=0; i<10; ++i) {
			AddTask task = new AddTask(deque);
			executorService.submit(task);
		}
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.printf("Add task has finished...\n");
		
		PoolTask poolTask = new PoolTask(deque);
		Thread thread = new Thread(poolTask);
		thread.start();
		
		thread.join();
		
		System.out.printf("Pool task has finished...\n");
		
		System.out.printf("Deque list size : %d \n",deque.size());
	}
}
