package com.shma.jcip.chapter05;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Memoizer3<K, V> implements Computable<K, V> {

	private final Map<K, Future<V>> cache = new ConcurrentHashMap<K, Future<V>>();

	private final Computable<K, V> c;

	public Memoizer3(Computable<K, V> c) {
		this.c = c;
	}

	@Override
	public V compute(final K arg) throws InterruptedException {
		Future<V> vFuture = cache.get(arg);
		if(vFuture == null) {
			FutureTask<V> vf = new FutureTask<V>(new Callable<V>() {

				@Override
				public V call() throws Exception {
					// TODO Auto-generated method stub
					return c.compute(arg);
				}
			});
			vFuture = vf;
			cache.put(arg, vFuture);
			vf.run();
		}
		
		try {
			return vFuture.get();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	class ExpensiveFunction implements Computable<String, BigInteger> {
		public BigInteger compute(String arg) {
			return new BigInteger(arg);
		}
	}
}
