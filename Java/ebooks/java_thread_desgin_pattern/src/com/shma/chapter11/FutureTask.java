package com.shma.chapter11;

/**
 * 
 * @author admin
 *
 * @param <V>
 */
public class FutureTask<V> implements Future<V> {

	private RealTask realTask;
	
	private final Callable<V> task;
	
	public FutureTask(Callable<V> task) {
		this.task = task;
	}
	
	public void execute() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.err.println("realtask begin...");
				realTask = new RealTask(task);
				realTask.execute();
				System.err.println("realtask end...");
			}
		}).start();
	}
	
	@Override
	public V get() {
		realTask.ready();
		return realTask.get();
	}

	private class RealTask implements Future<V> {

		private volatile boolean isReady = false;
		
		private Callable<V> callable;
		
		private V data;
		
		public RealTask(Callable<V> callable) {
			this.callable = callable;
		}

		@Override
		public V get() {
			return data;
		}

		public void ready() {
			synchronized(this) {
				while(!isReady) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		@Override
		public void execute() {
			try {
				data = callable.call();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			isReady = true;
			
			synchronized(this) {
				notifyAll();
			}
		}

	}
	
}
