package com.shma.concurrency.chapter10;

public class SycnrhoizedCounter {

	public static void main(String[] args) {
		
		/**
		 * �����������̡߳����ǵĹ���������ͬһ��Counterʵ����
		 * Counter.add������ͬ����ʵ���ϣ�����Ϊadd������ʵ���������ұ������synchronized�ؼ��֡�
		 * ���ÿ��ֻ����һ���̵߳��ø÷���������һ���̱߳���Ҫ�ȵ���һ���߳��˳�add()����ʱ�����ܼ���ִ�з�����
		 */
		Counter counter = new Counter();
		CounterThread thread01 = new CounterThread(counter, "thread01");
		CounterThread thread02 = new CounterThread(counter, "thread02");
		thread01.start();
		thread02.start();
		
		/**
		 * �������̣߳�threadA��threadB����������ͬһ��counterʵ����
		 * CounterA��counterB��add����ͬ�������������Ķ����ϡ�
		 * ����counterA��add������������������counterB��add������
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