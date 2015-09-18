package com.shma.jcip.chapter13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	public void parse() {
		
		Lock lock = new ReentrantLock();

		lock.lock();
		try {

		} finally {
			lock.unlock();
		}
	}
}
