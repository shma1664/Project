package com.shma.concurrency.chapter04.recipe02;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

	private final ThreadPoolExecutor exec;

	public Server() {
		super();
		this.exec = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	}
	
	public void doTask(Task task) {
		System.out.printf("Server: A new task has arrived\n");
		exec.execute(task);
		System.out.printf("Server: Pool Size: %d\n", exec.getPoolSize());
		System.out.printf("Server: Active Count: %d\n",exec.getActiveCount());
		System.out.printf("Server: Completed Tasks: %d\n",exec.getCompletedTaskCount());
		System.out.printf("Server: Task Count: %d\n",exec.getTaskCount());
	}
	
	public void shutdown() {
		exec.shutdown();
	}
}
