package com.shma.chapter10;

public class Main {

	public static void main(String[] args) {
		Channel<WoTou> channel = new Channel<WoTou>(WoTou.class, 20);
		new ProducerThread("Producer01", channel).start();
		new ProducerThread("Producer02", channel).start();
//		new ProducerThread("Producer03", channel).start();
//		new ProducerThread("Producer04", channel).start();
//		new ProducerThread("Producer05", channel).start();
		
		new ConsumerThread("Consumer01", channel).start();
		new ConsumerThread("Consumer02", channel).start();
		new ConsumerThread("Consumer03", channel).start();
		new ConsumerThread("Consumer04", channel).start();
	}
}
