package com.shma.chapter04;

public class TestMain {

	public static void main(String[] args) {
		Person person = new Person("m马韶华", "m安徽芜湖");
		Person person2 = new Person("q齐娇娇", "q河北保定");
		
		new PrintPersonThread("线程1", person).start();
		new PrintPersonThread("线程2", person2).start();
		new PrintPersonThread("线程3", person).start();
		new PrintPersonThread("线程4", person2).start();
		new PrintPersonThread("线程5", person).start();
		new PrintPersonThread("线程6", person2).start();
		new PrintPersonThread("线程7", person).start();
	}
}
