package com.shma.concurrency.chapter04.recipe06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import com.google.common.collect.Lists;

public class InvokeTest {

	@Test
	public void testInvokeAny01() {
		ExecutorService exec = Executors.newCachedThreadPool();

		List<Callable<String>> dataList = Lists.newArrayList();

		Callable<String> sleepSecondsCallable01 = new SleepSecondsCallable(
				"task1", 5);
		Callable<String> sleepSecondsCallable02 = new SleepSecondsCallable(
				"task2", 10);

		dataList.add(sleepSecondsCallable01);
		dataList.add(sleepSecondsCallable02);

		try {
			String resultList = exec.invokeAny(dataList);

			System.out.println(resultList);

			exec.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testInvokeAny02() {
		ExecutorService exec = Executors.newCachedThreadPool();

		List<Callable<String>> dataList = Lists.newArrayList();

		Callable<String> task1 = new ExceptionCallable();
		Callable<String> task2 = new ExceptionCallable();
		Callable<String> task3 = new ExceptionCallable();

		dataList.add(task1);
		dataList.add(task2);
		dataList.add(task3);

		try {
			String resultList = exec.invokeAny(dataList);

			System.out.println(resultList);

			exec.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testInvokeAny03() {
		ExecutorService exec = Executors.newCachedThreadPool();

		List<Callable<String>> dataList = Lists.newArrayList();

		Callable<String> task1 = new ExceptionCallable();
		Callable<String> task2 = new ExceptionCallable();
		Callable<String> task3 = new ExceptionCallable();
		Callable<String> task4 = new SleepSecondsCallable("task4", 10);

		dataList.add(task1);
		dataList.add(task2);
		dataList.add(task3);
		dataList.add(task4);

		try {
			String resultList = exec.invokeAny(dataList);

			System.out.println(resultList);

			exec.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testInvokeAny04() {
		ExecutorService exec = Executors.newCachedThreadPool();

		List<Callable<String>> dataList = Lists.newArrayList();

		Callable<String> task1 = new ExceptionCallable();
		Callable<String> task2 = new ExceptionCallable();
		Callable<String> task3 = new ExceptionCallable();
		Callable<String> task4 = new SleepSecondsCallable("task4", 10);

		dataList.add(task1);
		dataList.add(task2);
		dataList.add(task3);
		dataList.add(task4);

		try {
			String resultList = exec.invokeAny(dataList, 2, TimeUnit.SECONDS);

			System.out.println(resultList);

			exec.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testInvokeAll() {
		ExecutorService exec = Executors.newFixedThreadPool(5);

		List<Callable<String>> tasks = new ArrayList<Callable<String>>();
		tasks.add(new SleepSecondsCallable("t1", 2));
		tasks.add(new SleepSecondsCallable("t2", 2));
		tasks.add(new RandomTenCharsTask());
//		tasks.add(new ExceptionCallable());

		try {
			List<Future<String>> results = exec.invokeAll(tasks);
			// 任务列表中所有任务执行完毕,才能执行该语句
			System.out.println("wait for the result." + results.size());

			exec.shutdown();

			for (Future<String> f : results) {
				// isCanceled=false,isDone=true
				System.out.println("isCanceled=" + f.isCancelled() + ",isDone="
						+ f.isDone());

				// ExceptionCallable任务会报ExecutionException
				System.out.println("task result=" + f.get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
