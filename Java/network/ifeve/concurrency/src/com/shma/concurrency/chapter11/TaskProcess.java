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
			print(username + "ȡǮ����δ��ɣ���ǰ���" + cost + "���ȴ���...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		print("------����������-------");
		cost = data.get(username);
		print(username + "��ǰ���Ϊ��" + cost);
		cost = cost - 500;
		data.put(username, cost);
		
		print(username + "ȡ����500Ԫ��ʣ����Ϊ��" + data.get(username));
	}
	
	private void print(String line) {
		System.out.println(Thread.currentThread().getName() + " : " + line);
	}

}
