package com.shma.jcip.chapter10;

import java.util.Random;

import com.shma.jcip.chapter10.DynamicOrderDeadlock.Account;
import com.shma.jcip.chapter10.DynamicOrderDeadlock.DollarAmount;

public class DemonstrateDeadlock {

	public static final int NUM_THREADS = 20;
	public static final int NUM_ACCOUNTS = 5;
	public static final int NUM_ITERATIONS = 1000000;
	
	public static void main(String[] args) {
		final Random rnd = new Random();
		final Account[] accounts = new Account[NUM_ACCOUNTS];
		 class TransferThread extends Thread {
	            public void run() {
	                for (int i = 0; i < NUM_ITERATIONS; i++) {
	                    int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
	                    int toAcct = rnd.nextInt(NUM_ACCOUNTS);
	                    DollarAmount amount = new DollarAmount(rnd.nextInt(1000));
	                    try {
	                        DynamicOrderDeadlock.transferMoney(accounts[fromAcct], accounts[toAcct], amount);
	                    } catch (DynamicOrderDeadlock.InsufficientFundsException ignored) {
	                    }
	                }
	            }
	        }
	        for (int i = 0; i < NUM_THREADS; i++)
	            new TransferThread().start();
	}
}
