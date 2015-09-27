package com.shma.jcip.chapter05;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Memoizer4<K, V> implements Computable<K, V> {

	private final ConcurrentHashMap<K, Future<V>> cache = new ConcurrentHashMap<K, Future<V>>();

	private final Computable<K, V> c;

	public Memoizer4(Computable<K, V> c) {
		this.c = c;
	}

	@Override
	public V compute(final K arg) throws InterruptedException {
		while(true) {
			Future<V> vFuture = cache.get(arg);
			if(vFuture == null) {
				FutureTask<V> vf = new FutureTask<V>(new Callable<V>() {

					@Override
					public V call() throws Exception {
						// TODO Auto-generated method stub
						return c.compute(arg);
					}
				});
				vFuture = cache.putIfAbsent(arg, vf);
				if(vFuture == null) {
					vFuture = vf;
					vf.run();
				}
			}
			
			try {
				return vFuture.get();
			} catch (ExecutionException e) {
				cache.remove(arg, vFuture);
			}
		}
	}
	
	class ExpensiveFunction implements Computable<String, BigInteger> {
		public BigInteger compute(String arg) {
			return new BigInteger(arg);
		}
	}
}
