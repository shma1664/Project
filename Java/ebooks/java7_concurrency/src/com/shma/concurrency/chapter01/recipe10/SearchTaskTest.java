package com.shma.concurrency.chapter01.recipe10;

import java.util.concurrent.TimeUnit;

import org.junit.Test;


public class SearchTaskTest {

	@Test
	public void test() {
		ThreadGroup group = new ThreadGroup("searchTask");
		
		for(int i=0; i<10; ++i) {
			new Thread(group, new SearchTask(), "SearchTask" + i).start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.printf("Number of Threads: %d\n", group.activeCount());
		System.out.printf("Information about the Thread Group\n");
		group.list();
		
		Thread[] threads = new Thread[group.activeCount()];
		group.enumerate(threads);
		
		for (int i=0; i<group.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n",threads[i].getName(),threads[i].getState());
		}

		waitFisihed(group);
		
		group.interrupt(); //中断其他线程
		
	}
	
	private static void waitFisihed(ThreadGroup group) {
		while(group.activeCount() > 9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
