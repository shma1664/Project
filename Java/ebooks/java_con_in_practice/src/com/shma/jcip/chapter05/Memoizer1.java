package com.shma.jcip.chapter05;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Memoizer1<K, V> implements Computable<K, V> {

	private final Map<K, V> cache = new HashMap<K, V>();

	private final Computable<K, V> c;

	public Memoizer1(Computable<K, V> c) {
		this.c = c;
	}

	@Override
	public synchronized V compute(K arg) throws InterruptedException {
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
