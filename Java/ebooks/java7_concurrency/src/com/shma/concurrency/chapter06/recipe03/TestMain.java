package com.shma.concurrency.chapter06.recipe03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestMain {

	public static void main(String[] args) {
		
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<Event>(5);
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		int threadNum = 3;
		for(int i=0; i<threadNum; ++i) {
			Task task = new Task(i, queue);
			executorService.submit(task);
		}
		
		executorService.shutdown();
		
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Queue Size: %d\n",queue.size());
		for (int i=0; i<threadNum*1000; i++){
			Event event = null;
			try {
				event = queue.take();
				System.out.printf("Thread %s: Priority %d\n",event.getName(), event.getPriority());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Main: Queue Size: %d\n",queue.size());
		System.out.printf("Main: End of the program\n");
	}
}
