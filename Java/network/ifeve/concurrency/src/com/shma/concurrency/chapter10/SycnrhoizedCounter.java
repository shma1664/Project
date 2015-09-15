package com.shma.concurrency.chapter10;

public class SycnrhoizedCounter {

	public static void main(String[] args) {
		
		/**
		 * 创建了两个线程。他们的构造器引用同一个Counter实例。
		 * Counter.add方法是同步在实例上，是因为add方法是实例方法并且被标记上synchronized关键字。
		 * 因此每次只允许一个线程调用该方法。另外一个线程必须要等到第一个线程退出add()方法时，才能继续执行方法。
		 */
		Counter counter = new Counter();
		CounterThread thread01 = new CounterThread(counter, "thread01");
		CounterThread thread02 = new CounterThread(counter, "thread02");
		thread01.start();
		thread02.start();
		
		/**
		 * 这两个线程，threadA和threadB，不再引用同一个counter实例。
		 * CounterA和counterB的add方法同步在他们所属的对象上。
		 * 调用counterA的add方法将不会阻塞调用counterB的add方法。
		 */
		Counter counter03 = new Counter();
		Counter counter04 = new Counter();
		CounterThread thread03 = new CounterThread(counter03, "thread03");
		CounterThread thread04 = new CounterThread(counter04, "thread04");
		thread03.start();
		thread04.start();
	}
}

class Counter {
	private int count;
	
	public synchronized void add(int value) {
		count += value;
	}
	
	public synchronized int getCount() {
		return count;
	}
}

class CounterThread extends Thread {
	private Counter counter = null;

	public CounterThread(Counter counter, String theadName){
		super(theadName);
		this.counter = counter;
	}

	@Override
	public void run() {
		for(int i=0; i<10; ++i) {
			counter.add(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : " + counter.getCount());
		}
	}
}