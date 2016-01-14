package com.shma.concurrency.chapter01.recipe03;

public class PrimeGenerator extends Thread {

	@Override
	public void run() {
		long number = 1L;
		
		while(true) {
			if(isPrime(number)) {
				System.out.println("Number " + number + " is prime number");
			}
			
			if(isInterrupted()) {
				System.out.println("The Prime Generator has been interrupted");
				return;
			}
			
			number++;
		}
		
	}
	
	private boolean isPrime(long number) {
		if(number < 0) {
			return false;
		} 
		
		if(number <= 2) {
			return true;
		}
		
		for(int i=2; i<number; ++i) {
			if((number % i) == 0) {
				return false;
			}
		}
		
		return true;
	}

}
