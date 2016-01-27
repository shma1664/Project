package com.shma.concurrency.chapter04.recipe07;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建定时任务
 * @author admin
 *
 */
public class TestMain {

	public static void main(String[] args) {
		
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		
		for(int i=0; i<10; ++i) {
			Task task = new Task("Task-" + i);
			executorService.schedule(task, i, TimeUnit.SECONDS);
		}
		
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Core: Ends at: %s\n", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
