package com.shma.jcip.chapter13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock03 {

	private List<Integer> list = new ArrayList<Integer>();
	private final Lock lock = new ReentrantLock();
	private final ExecutorService executorService = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {
		
		final TestLock03 test = new TestLock03();
		
		test.run();
	}
	
	public void run() {
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(5);
		
		for(int i=0; i<5; ++i) {
			Task task = new Task(begin, end);
			executorService.execute(task);
		}
		begin.countDown();
		
		try {
			end.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("完成任务:" + list);
		executorService.shutdown();
	}
	
	class Task implements Runnable {
		
		private CountDownLatch begin;
		private CountDownLatch end;
		
		public Task(CountDownLatch begin, CountDownLatch end) {
			this.begin = begin;
			this.end = end;
		}
		
		@Override
		public void run() {
			try {
				begin.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while(true) {
				if(lock.tryLock()) {
					try {
						System.out.println("Thread " + Thread.currentThread().getName() + "得到了锁");
						for(int i=0; i<5; ++i) {
							list.add(i);
						}
						break;
					} finally {
						System.out.println("Thread " + Thread.currentThread().getName() + "释放了锁");
						lock.unlock();
						end.countDown();
					}
				} else {
					System.out.println("Thread " + Thread.currentThread().getName() + "得到了锁失败");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
