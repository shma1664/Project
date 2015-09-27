package com.shma.jcip.chapter08;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyAppThread extends Thread {

	private static final String DEFAULT_NAME = "MyAppThread";

	private static volatile boolean debugLifecycle = false;
	private static final AtomicInteger created = new AtomicInteger();
	private static final AtomicInteger alive = new AtomicInteger();
	private static final Logger log = Logger.getAnonymousLogger();

	public MyAppThread(Runnable runnable) {
		this(runnable, DEFAULT_NAME);
	}

	public MyAppThread(Runnable runnable, String threadName) {
		super(runnable, threadName + "-" + created.incrementAndGet());
		this.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				log.log(Level.SEVERE, "UNCAUGHT in thread " + t.getName(), e);
			}
		});
	}

	@Override
	public void run() {
		boolean debug = debugLifecycle;
		if (debug)
			log.log(Level.FINE, "Created " + getName());
		try {
			alive.incrementAndGet();
			super.run();
		} finally {
			alive.decrementAndGet();
			if (debug)
				log.log(Level.FINE, "Exiting " + getName());
		}
	}
}
