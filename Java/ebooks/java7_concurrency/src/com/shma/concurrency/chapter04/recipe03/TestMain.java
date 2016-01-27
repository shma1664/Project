package com.shma.concurrency.chapter04.recipe03;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Maps;

public class TestMain {

	public static void main(String[] args) {
		ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		Map<Integer, Future<Long>> futureMap = Maps.newHashMap();
		
		Random random = new Random();
		
		for(int i=0; i<20; ++i) {
			
			int value = random.nextInt(20);
			
			FactorialCalculator factorialCalculator = new FactorialCalculator(value);
			Future<Long> future = exec.submit(factorialCalculator);
			futureMap.put(value, future);
		}
		
		do {
			
			System.out.printf("Main: Number of Completed Tasks: %d\n", exec.getCompletedTaskCount());
			
			int i = 0;
			
			for(Iterator<Future<Long>> iterator = futureMap.values().iterator(); iterator.hasNext();) {
				Future<Long> future = iterator.next();
				System.out.printf("Main: Task %d: %s\n", i++, future.isDone());
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} while(exec.getCompletedTaskCount() < futureMap.keySet().size());
		
		
		System.out.printf("Main: Results\n");
		
		for(Entry<Integer, Future<Long>> entry : futureMap.entrySet()) {
			int data = entry.getKey();
			Future<Long> future = entry.getValue();
			
			try {
				System.out.printf("Core: Task %d = %d\n", data, future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		exec.shutdown();
	}
}
