package com.shma.concurrency.chapter11;

import java.util.Map;

public class TaskProcess implements Runnable {

	private MySignal signal;
	private Map<String, Integer> data;
	private String username;
	
	public TaskProcess(MySignal signal, Map<String, Integer> data, String username) {
		this.signal = signal;
		this.data = data;
		this.username = username;
	}
	
	@Override
	public void run() {
		Integer cost = 0;
		while(!signal.isHasDataToProcess()) {
			cost = data.get(username);
			if(cost == null) {
				cost = 0;
			}
			print(username + "取钱操作未完成，当前余额" + cost + "，等待中...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		print("------存入操作完成-------");
		cost = data.get(username);
		print(username + "当前余额为：" + cost);
		cost = cost - 500;
		data.put(username, cost);
		
		print(username + "取出了500元，剩余金额为：" + data.get(username));
	}
	
	private void print(String line) {
		System.out.println(Thread.currentThread().getName() + " : " + line);
	}

}
