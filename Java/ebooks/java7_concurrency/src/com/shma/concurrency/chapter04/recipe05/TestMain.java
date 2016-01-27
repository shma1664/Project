package com.shma.concurrency.chapter04.recipe05;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;

public class TestMain {

	public static void main(String[] args) {
		
		List<RandomStrTask> dataList = Lists.newArrayList();
		
		for(int i=0; i<10; ++i) {
			RandomStrTask task = new RandomStrTask("task-" + i, 10);
			dataList.add(task);
		}
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		List<Future<Result>> futures = null;
		
		try {
			futures = executorService.invokeAll(dataList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executorService.shutdown();
		
		System.out.printf("Core: Printing the results\n");
		
		for(Future<Result> future : futures) {
			if(future.isDone()) {
				Result result = null;
				try {
					result = future.get();
					System.out.printf("%s: %s\n",result.getName(),result.getData());
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
}
