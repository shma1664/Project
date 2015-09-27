package com.shma.jcip.chapter05;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Memoizer2<K, V> implements Computable<K, V> {

	private final Map<K, V> cache = new ConcurrentHashMap<K, V>();

	private final Computable<K, V> c;

	public Memoizer2(Computable<K, V> c) {
		this.c = c;
	}

	@Override
	public V compute(K arg) throws InterruptedException {
		V v = cache.get(arg);
		if(v == null) {
			v = c.compute(arg);
			cache.put(arg, v);
		}
		return v;
	}
	
	class ExpensiveFunction implements Computable<String, BigInteger> {
		public BigInteger compute(String arg) {
			return new BigInteger(arg);
		}
	}
}

interface Computable<K, V> {
	V compute(K arg) throws InterruptedException;
}
