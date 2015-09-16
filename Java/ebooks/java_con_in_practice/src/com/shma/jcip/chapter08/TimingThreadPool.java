package com.shma.jcip.chapter08;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class TimingThreadPool extends ThreadPoolExecutor {
	
	//开始时间
	private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	
	private final Logger logger = Logger.getLogger("TimingThreadPool");
	
	//任务个数
	private final AtomicLong numTask = new AtomicLong();
	
	private final AtomicLong totalTime = new AtomicLong();
	
	public TimingThreadPool() {
        super(1, 1, 0L, TimeUnit.SECONDS, null);
    }

	@Override
	protected void beforeExecute(Thread paramThread, Runnable paramRunnable) {
		super.beforeExecute(paramThread, paramRunnable);
		logger.info(String.format("Thread %s : start %s", paramRunnable));
		startTime.set(System.currentTimeMillis());
	}

	@Override
	protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable) {
		super.afterExecute(paramRunnable, paramThrowable);
		long endTime = System.currentTimeMillis();
		long taskTime = endTime - startTime.get();
		totalTime.addAndGet(taskTime);
		numTask.incrementAndGet();
		
		logger.fine(String.format("Thread %s : end %s,  time=%dns", paramThrowable, paramRunnable, taskTime));
	}

	@Override
	protected void terminated() {
		try {
			logger.info(String.format("Terminated : avg time=%dns",  totalTime.get() / numTask.get()));
		} finally {
			super.terminated();
		}
	}
}
