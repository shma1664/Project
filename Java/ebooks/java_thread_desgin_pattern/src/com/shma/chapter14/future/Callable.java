package com.shma.chapter14.future;

public interface Callable<V> {

	public V call() throws Exception;
}
