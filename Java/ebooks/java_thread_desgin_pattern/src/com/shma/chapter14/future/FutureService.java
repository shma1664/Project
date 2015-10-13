package com.shma.chapter14.future;

public class FutureService<V> implements Future<V> {

	private Callable<V> callable;
	
	private RealService realService;

	@Override
	public V get() {
		return realService.get();
	}

	@Override
	public void execute() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Real begin...");
				realService = new RealService();
				realService.execute();
				System.out.println("Real end...");
			}
		}).start();
	}
	
	private class RealService implements Future<V> {
		
		private volatile boolean isReady = false;
		
		private V data;
		
		@Override
		public V get() {
			ready();
			return data;
		}
		
		private void ready() {
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
