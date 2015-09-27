package com.shma.jcip.chapter08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class BoundedExecutor {

	private final ExecutorService exec;
	
	private final Semaphore semaphore;
	
	public BoundedExecutor(ExecutorService exec, int threadNum) {
		this.exec = exec;
		this.semaphore = new Semaphore(threadNum);
	}
	
	/**
	 * 通过信号量去控制任务到达率
	 * @throws InterruptedException 
	 */
	public void submitTask(final Runnable command) throws InterruptedException {
		semaphore.acquire();
		
		try {
			exec.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						command.run();
					} finally {
						semaphore.release();
					}
				}
			});
		} finally {
			semaphore.release();
		}
	}
}
