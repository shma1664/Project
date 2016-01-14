package com.shma.concurrency.chapter01.recipe07;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

/**
 * 守护线程
 * @author admin
 *
 */
public class DaemonThreadTest {

	@Test
	public void test() {
		
		Deque<Event> deque = new ArrayDeque<Event>();
		WorkerTask workerTask = new WorkerTask(deque);
		for(int i=0; i<3; ++i) {
			new Thread(workerTask, "workerTask" + i).start();
		}
		
		Thread thread = new Thread(new CleanWorker(deque), "cleanWorker");
		//设置为守护线程，再调用start之前
		thread.setDaemon(true);
		thread.start();
		
		
	}
}
