package com.shma.jcip.chapter07;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BrokenPrimeProducer implements Runnable {

	private BlockingQueue<BigInteger> queue = null;
	
	private volatile boolean cancel = false;
	
	BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		BigInteger bigInteger = BigInteger.ONE;
		while(!cancel) {
			try {
				queue.put(bigInteger = bigInteger.nextProbablePrime());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void cancel() {
		cancel = true;
	}
	
	private final ExecutorService executorService = Executors.newCachedThreadPool();
	
	public void consumerPrimes() {
		BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(10);
		BrokenPrimeProducer producer = new BrokenPrimeProducer(queue);
		executorService.execute(producer);
		
		while(!hasNeedNextInteger()) {
			try {
				BigInteger bigInteger = queue.take();
				parseBigInteger(bigInteger);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private boolean hasNeedNextInteger() {
		return false;
	}
	
	public void parseBigInteger(BigInteger bigInteger) {
		
	}
	
}
