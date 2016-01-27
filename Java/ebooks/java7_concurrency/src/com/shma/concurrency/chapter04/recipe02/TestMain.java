package com.shma.concurrency.chapter04.recipe02;

import java.util.Date;

public class TestMain {

	public static void main(String[] args) {
		Server server = new Server();
		
		for(int i=0; i<100; ++i) {
			Task task = new Task(new Date(), "Task-" + i);
			server.doTask(task);
		}
		
		server.shutdown();
	}
}
