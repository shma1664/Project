package com.shma.chapter14.future;

public interface Future<V> {

	public V get();
	
	public void execute();
}
