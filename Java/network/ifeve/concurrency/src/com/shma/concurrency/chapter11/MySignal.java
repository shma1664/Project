package com.shma.concurrency.chapter11;

public class MySignal {

	private boolean hasDataToProcess = false;

	public synchronized boolean isHasDataToProcess() {
		return hasDataToProcess;
	}

	public synchronized void setHasDataToProcess(boolean hasDataToProcess) {
		this.hasDataToProcess = hasDataToProcess;
	}
	
	
}
