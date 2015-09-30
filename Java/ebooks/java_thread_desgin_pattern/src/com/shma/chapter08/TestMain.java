package com.shma.chapter08;

public class TestMain {

	public static void main(String[] args) {
		Data data = new Data(10);
		new ReadThread("readThread01", data).start();
		new ReadThread("readThread02", data).start();
		new ReadThread("readThread03", data).start();
		new ReadThread("readThread04", data).start();
		new ReadThread("readThread05", data).start();
		new ReadThread("readThread06", data).start();
		new ReadThread("readThread07", data).start();
		new ReadThread("readThread08", data).start();
		new ReadThread("readThread09", data).start();
		new ReadThread("readThread10", data).start();
		
		new WriterThread("writerThread01", data, "ABCDEFG").start();
	}
}
