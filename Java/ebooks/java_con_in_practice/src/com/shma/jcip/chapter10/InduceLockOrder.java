package com.shma.jcip.chapter10;

import com.shma.jcip.annotation.ThreadSafe;

@ThreadSafe
public class InduceLockOrder {

	private final Object tieLock = new Object();
	
	public void transferMoney(final Account fromAcct, final Account toAcct,
			final DollarAmount amount) throws InsufficientFundsException {
		class Helper {
			public void transfer() throws InsufficientFundsException {
				if (fromAcct.getBalance().compareTo(amount) < 0)
					throw new InsufficientFundsException();
				else {
					fromAcct.debit(amount);
					toAcct.credit(amount);
				}
			}
		}

		int formHash = System.identityHashCode(fromAcct);
		int toHash = System.identityHashCode(toAcct);

		if (formHash > toHash) {
			synchronized (toAcct) {
				synchronized (fromAcct) {
					new Helper().transfer();
				}
			}
		} else if (formHash < toHash) {
			synchronized (fromAcct) {
				synchronized (toAcct) {
					new Helper().transfer();
				}
			}
		} else {
			synchronized (tieLock) {
				synchronized (fromAcct) {
					synchronized (toAcct) {
						new Helper().transfer();
					}
				}
			}
		}
	}

	interface DollarAmount extends Comparable<DollarAmount> {
	}

	interface Account {
		void debit(DollarAmount d);

		void credit(DollarAmount d);

		DollarAmount getBalance();

		int getAcctNo();
	}

	class InsufficientFundsException extends Exception {
	}
}
