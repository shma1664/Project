package com.shma.concurrency.chapter04.recipe08;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TestMain {

	public static void main(String[] args) {
		
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		
		Task2 task = new Task2("Task");
		
		ScheduledFuture<?> future = executorService.scheduleWithFixedDelay(task, 3, 1, TimeUnit.SECONDS);
		
		for(int i=0 ; i<20; ++i) {
			System.out.printf("Main: Delay: %d\n", future.getDelay(TimeUnit.MILLISECONDS));
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		executorService.shutdown();
		
		System.out.printf("Main: No more tasks at: %s\n",new Date());
		// Verify that the periodic tasks no is in execution after the executor shutdown()
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// The example finish
		System.out.printf("Main: Finished at: %s\n",new Date());
		
	}
}
