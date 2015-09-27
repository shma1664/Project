package com.shma.jcip.chapter07;

import java.util.concurrent.BlockingQueue;

public class NoncancelableTask {

	public Task getNextTask(BlockingQueue<Task> queue) {
		
		boolean interrupted = false;
		
		try {
			while(true) {
				try {
					return queue.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					interrupted = true;
				}
			}
		} finally {
			if(interrupted) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	
	interface Task {
    }
}
