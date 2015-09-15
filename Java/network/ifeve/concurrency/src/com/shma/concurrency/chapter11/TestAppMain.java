package com.shma.concurrency.chapter11;

import java.util.HashMap;
import java.util.Map;

public class TestAppMain {

	public static void main(String[] args) {
		MySignal signal = new MySignal();
		Map<String, Integer> data = new HashMap<String, Integer>();
		Thread prepare = new Thread(new TaskPrepare(signal, data, "张三"), "prepare");
		Thread process = new Thread(new TaskProcess(signal, data, "张三"), "process");
		process.start();
		prepare.start();
	}
}
