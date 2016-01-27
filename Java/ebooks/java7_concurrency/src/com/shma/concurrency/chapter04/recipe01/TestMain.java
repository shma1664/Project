package com.shma.concurrency.chapter04.recipe01;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestMain {

	public static void main(String[] args) {
		Server server = new Server();
		
		for(int i=0; i<20; ++i) {
			Task task = new Task(new Date(), "Task-" + i);
			server.doTask(task);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		
		server.shutdown();
	}
}
