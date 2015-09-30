package com.shma.chapter08;

public class Data {

	private final ReaderWriterLock lock;
	
	private final char[] buffer;

	public Data(int size) {
		super();
		this.lock = new ReaderWriterLock();
		buffer = new char[size];
		
		for(int index=0; index<size; ++index) {
			buffer[index] = '*';
		}
	}
	
	public char[] read() throws InterruptedException {
		
		lock.readLock();
		
		try {
			char[] copyBuffer = new char[buffer.length];
			System.arraycopy(buffer, 0, copyBuffer, 0, buffer.length);
			slowly();
			return copyBuffer;
 		} finally {
 			lock.unReadLock();
 		}
	}
	
	public void write(char c) throws InterruptedException {
		lock.writeLock();
		
		try {
			
			for(int index=0; index<buffer.length; ++index) {
				buffer[index] = c;
				slowly();
			}
			
		} finally {
			lock.unWriteLock();
		}
	}
	
	private void slowly() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
