package com.shma.jcip.chapter05;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class BoundedHashSet<T> {

	private final Set<T> set;
	private final Semaphore semaphore;
	
	public BoundedHashSet(int bound) {
		set = Collections.synchronizedSet(new HashSet<T>());
		semaphore = new Semaphore(bound);
	}
	
	public boolean add(T t) throws InterruptedException {
		semaphore.acquire();
		boolean flag = false;
		
		try {
			flag = set.add(t);
			return flag;
		} finally {
			if(!flag) {
				semaphore.release();
			}
		}
	}
	
	public boolean remove(T t) {
		boolean flag = set.remove(t);
		if(flag) {
			semaphore.release();
		}
		return flag;
	}
}
