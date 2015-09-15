package com.shma.concurrency.chapter11;

import java.util.Map;

public class TaskPrepare implements Runnable {

	private MySignal signal;
	private Map<String, Integer> data;
	private String username;
	
	public TaskPrepare(MySignal signal, Map<String, Integer> data, String username) {
		this.signal = signal;
		this.data = data;
		this.username = username;
	}
	
	@Override
	public void run() {
		print(username + "准备存入现金，系统等待10s....");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer cost = data.get(username);
		if(cost == null) {
			cost = 0;
		}
		
		cost += 1000;
		data.put(username, cost);
		print(username + "存入现金" + 1000 + "元，余额：" + cost +"....");
		signal.setHasDataToProcess(true);
	}
	
	private void print(String line) {
		System.out.println(Thread.currentThread().getName() + " : " + line);
	}

}
