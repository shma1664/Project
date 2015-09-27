package com.shma.jcip.chapter05;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumer {

	public static void main(String[] args) {
		BlockingQueue<WoTou> queue = new LinkedBlockingDeque<WoTou>(10);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
	}
}

class WoTou {
	
	private int id;
	
	public WoTou(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return Thread.currentThread().getName() + " : WoTou [id=" + id + "]";
	}
}

class Producer implements Runnable {

	private BlockingQueue<WoTou> queue = null;
	
	public Producer(BlockingQueue<WoTou> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; ++i) {
			WoTou woTou = new WoTou(i);
			try {
				queue.put(woTou);
				System.out.println(Thread.currentThread().getName() + "生产了:" + woTou);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
	
}

class Consumer implements Runnable {

	private BlockingQueue<WoTou> queue = null;
	
	public Consumer(BlockingQueue<WoTou> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; ++i) {
			try {
				WoTou woTou = queue.take();
				System.out.println(Thread.currentThread().getName() + "消费了:" + woTou);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
	
}
