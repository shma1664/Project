package com.shma.jcip.chapter07;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.shma.jcip.annotation.ThreadSafe;

@ThreadSafe
public class PrimeGenerator implements Runnable {

	private static final List<BigInteger> primes = new ArrayList<BigInteger>();
	
	private volatile boolean cancel = false;
	
	public synchronized List<BigInteger> get() {
		return new ArrayList<BigInteger>(primes);
	}

	@Override
	public void run() {
		BigInteger pBigInteger = BigInteger.ONE;
		while(!cancel) {
			pBigInteger = pBigInteger.nextProbablePrime();
			synchronized (this) {
				primes.add(pBigInteger);
			}
		}
	}
	
	public void cancel() {
		cancel = true;
	}
	
	private final ExecutorService exec = Executors.newCachedThreadPool();
	
	public List<BigInteger> aSecondOfPrimes() {
		PrimeGenerator primeGenerator = new PrimeGenerator();
		exec.execute(primeGenerator);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			primeGenerator.cancel();
		}
		
		return primeGenerator.get();
	}
}
