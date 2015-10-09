package com.shma.chapter11;

public interface Future<V> {

	public V get();
	
	public void execute();
}
