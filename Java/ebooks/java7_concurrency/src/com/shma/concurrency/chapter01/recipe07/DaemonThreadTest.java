package com.shma.concurrency.chapter01.recipe07;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

/**
 * �ػ��߳�
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
		//����Ϊ�ػ��̣߳��ٵ���start֮ǰ
		thread.setDaemon(true);
		thread.start();
		
		
	}
}
