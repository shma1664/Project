package com.shma.concurrency.chapter11;

import java.util.HashMap;
import java.util.Map;

public class TestAppMain {

	public static void main(String[] args) {
		MySignal signal = new MySignal();
		Map<String, Integer> data = new HashMap<String, Integer>();
		Thread prepare = new Thread(new TaskPrepare(signal, data, "����"), "prepare");
		Thread process = new Thread(new TaskProcess(signal, data, "����"), "process");
		process.start();
		prepare.start();
	}
}
